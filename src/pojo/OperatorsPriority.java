package pojo;

/**
 *
 * @author Sluski
 */
public class OperatorsPriority {
    private String value;
    private int scale;

    public OperatorsPriority(String operator, int scale){
        this.value = operator;
        this.scale = scale;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
