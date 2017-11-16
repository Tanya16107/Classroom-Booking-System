import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;
import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
public class Apple3
{
	@FXML
	ListView<String> l1;

	@FXML
	Button l4;

	@FXML
	TextField l2;
	
	Student S=new Student("lsd","69");
	
	public Apple3()
	{
	}
	public void initialize()
	{
	}
	public void WOW()
	{
		try{
			String S1=l1.getSelectionModel().getSelectedItem();
            List<Course> L=new ArrayList<Course>();
            FileInputStream F=new FileInputStream("db_Courses.txt");
            ObjectInputStream O=new ObjectInputStream(F);
            L=(List<Course>)O.readObject();
            for(int i=0;i<L.size();i++)
            {
            	if(L.get(i).toString().equals(S1))
            	{
            		S.AddMandatory(L.get(i));
            		LOL();
            		break;
            	}
            }
            S.viewTimeTable();

		}catch(Exception E)
		{
			E.printStackTrace();
		}

	} 
	public void LOL()
	{

        try{

			String S1=l2.getText();
			Search Se=new Search();
            List<Course> L=new ArrayList<Course>();
            FileInputStream F=new FileInputStream("db_Courses.txt");
            ObjectInputStream O=new ObjectInputStream(F);
            L=(List<Course>)O.readObject();   
            //S.AddMandatory(L.get(0));
            //S.AddMandatory(L.get(1));
            //S.AddMandatory(L.get(2));
            //S.AddMandatory(L.get(12));
            //S.AddMandatory(L.get(6));
			ArrayList<String> T=Se.ShowSearch(S,S1);
            ObservableList<String> data = FXCollections.observableArrayList();
            data.addAll(T);
            l1.setItems(data);
        }catch(Exception E){
           E.printStackTrace();
        }

	}
}