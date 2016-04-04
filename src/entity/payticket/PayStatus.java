package entity.payticket;

/**
 * Created by Vadim on 04.04.2016.
 */
public enum PayStatus {
    OK("Оплачено"),
    ERROR("Не удалось оплатить");

    private String value;

    PayStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
