package frc.robot;

public class ColorThreshold
{
    private double _redMin, _greenMin, _blueMin;

    public ColorThreshold(double redVal, double greenVal, double blueVal)
    {
        _redMin = redVal;
        _blueMin = blueVal;
        _greenMin = greenVal;
    }

    public boolean inThreshhold(double redVal, double greenVal, double blueVal) // Check if color is above a threshold in all three colors
    {
        return ((redVal >= _redMin) && (greenVal >= _greenMin) && (blueVal >= _blueMin));
    }
}
