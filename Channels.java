public class Channels {
    private String nameOfChannel;
    private float price;

    public String getNameOfChannel()
    {
        return nameOfChannel;
    }

    public void setNameOfChannel(String nameOfChannel)
    {
        this.nameOfChannel = nameOfChannel;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Channels(String nameOfChannel, float price) {
        this.nameOfChannel = nameOfChannel;
        this.price = price;
    }



}
