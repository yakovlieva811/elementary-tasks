package envelope;

public class Envelope {

    private double height;
    private double width;

    public Envelope(double height, double width) {
        this.height = height;
        this.width = width;
    }


    boolean putTo(Envelope secondEnvelope) {
        if (this.height < secondEnvelope.height && this.width < secondEnvelope.width) {

            return true;
        }
        return false;
    }


    boolean putWithAngleIn(Envelope intoEnvelope) {
        this.sortSides();
        intoEnvelope.sortSides();
        if (this.width > intoEnvelope.width && this.height <= intoEnvelope.height &&
                (Math.pow(((intoEnvelope.width + intoEnvelope.height) / (this.width + this.height)), 2)) +
                        (Math.pow(((intoEnvelope.width - intoEnvelope.height) / (this.width - this.height)), 2)) >= 2
        ) {
            return true;
        }
        return false;
    }


    private void sortSides() {
        if (height > width) {
            double temp = height;
            height = width;
            width = temp;
        }
    }
}
