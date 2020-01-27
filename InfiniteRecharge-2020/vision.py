import cv2
import numpy as np
import math

targetHeight = 11
cameraViewAngle = 36.5

cap = None
cameraWidth = 0
cameraHeight = 0

def startCapture(cameraPath, width, height):
  # Tells the function to use the global definotion of cap
  global cap

  # Create a VideoCapture object and read from input file
  # If the input is the camera, pass 0 instead of the video file name
  cap = cv2.VideoCapture(cameraPath)
  cameraWidth = width
  cameraHeight = height
 
# Read until video is completed
def processNextFrame():
  global cap

  # Capture frame-by-frame
  ret, frame = cap.read()

  if ret == True:
    lowerBound = np.array([60, 100, 100])
    upperBound = np.array([120, 255 ,255])

    hsvImage = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
    mask = cv2.inRange(hsvImage, lowerBound, upperBound)
    maskedFrame = cv2.bitwise_and(frame, frame, mask=mask)

    grayFrame = cv2.cvtColor(maskedFrame, cv2.COLOR_BGR2GRAY)
    _, contours, _ = cv2.findContours(grayFrame, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

    filteredContours = []

    for contour in contours:
        if cv2.contourArea(contour) > 1000:
            filteredContours.append(contour)

    if len(filteredContours) > 0:
      topLeftX, topLeftY, width, height = cv2.boundingRect(filteredContours[0])
      maskedFrame = cv2.rectangle(maskedFrame, (topLeftX, topLeftY), (topLeftX + width, topLeftY + height), (0, 255, 0) , 2)

      inchPixelRatio = targetHeight / height

      frameWidth = inchPixelRatio * 1280 / 2

      distanceToTarget = frameWidth / math.tan(math.radians(cameraViewAngle))
      
      centerOfTarget = topLeftX + width/2 
      centerOffset = centerOfTarget - (1280 / 2)
      
      return(distanceToTarget, centerOffset, maskedFrame, frame)
    else:
      return(0, 0, 0, 0)