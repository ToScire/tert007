package entity.payticket;

/**
 * Created by Vadim on 04.04.2016.
 */
public enum PaySystem {
    WEBMONEY("Webmoney"),
    BYCARD("ByCard");

    private final String value;

    PaySystem(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

