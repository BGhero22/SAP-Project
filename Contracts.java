import java.util.ArrayList;
import java.util.List;

public class Contracts {
   private String nameofDeliver;
   private String number;
   private String lengthOfContract;
   private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getNameofDeliver() {
        return nameofDeliver;
    }

    public void setNameofDeliver(String nameofDeliver) {
        this.nameofDeliver = nameofDeliver;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLengthOfContract() {
        return lengthOfContract;
    }

    public void setLengthOfContract(String lengthOfContract) {
        this.lengthOfContract = lengthOfContract;
    }

    public Contracts(String nameofDeliver, String number, String lengthOfContract,float value) {
        this.nameofDeliver = nameofDeliver;
        this.number = number;
        this.lengthOfContract = lengthOfContract;
        this.value = value;

    }
    static List<String> contracts = new ArrayList<String>();
}
