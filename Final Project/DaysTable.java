import javafx.beans.property.SimpleStringProperty;
 
public class DaysTable {
   public final SimpleStringProperty day = new SimpleStringProperty("");


    public DaysTable() {
        this("");
    }
 
    public DaysTable(String day) {
        setDay(day);
    }
 
    public void setDay(String x) {
        day.set(x);
    }

    public String getDay(){
        return day.get();
    }
}