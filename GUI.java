import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class GUI extends Application implements EventHandler<ActionEvent>{
	
	Button button;
	OS os;
	static Circle ucircle1;
	static Circle ucircle2;
	static Circle ucircle3;
	static Circle ucircle4;
	static Text utext1;
	static Text utext2;
	static Text utext3;
	static Text utext4;
	
	static Circle dcircle1;
	static Circle dcircle2;
	static Text dtext1;
	static Text dtext2;
	
	static Circle pcircle1;
	static Circle pcircle2;
	static Circle pcircle3;
	static Text ptext1;
	static Text ptext2;
	static Text ptext3;
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("ICS 141 OS");
		
		os = new OS();
		
		button = new Button("Start simulation");
		button.setOnAction(this);
		button.setPadding(new Insets(15,12,15,12));
		button.setStyle("-fx-background-color: #33DEFF");
		button.setLayoutX(180);
		button.setLayoutY(0);
		
		ucircle1 = new Circle(60,50,30, Color.LIGHTSKYBLUE);
		ucircle2 = new Circle(60,120,30,Color.LIGHTSKYBLUE);
		ucircle3 = new Circle(60,190,30,Color.LIGHTSKYBLUE);
		ucircle4 = new Circle(60,260,30,Color.LIGHTSKYBLUE);
		ucircle1 = new Circle(60,50,30, Color.LIGHTSKYBLUE);
		utext1 = new Text(40,55,"User 1");
		utext2 = new Text(40,125,"User 2");
		utext3 = new Text(40,195,"User 3");
		utext4 = new Text(40,265,"User 4");
		
		dcircle1 = new Circle(250,80,30, Color.LIGHTSKYBLUE);
		dcircle2 = new Circle(250,150,30, Color.LIGHTSKYBLUE);
		dtext1 = new Text(230,85,"Disk 1");
		dtext2 = new Text(230,155,"Disk 2");
		
		pcircle1 = new Circle(440,65,30, Color.LIGHTSKYBLUE);
		pcircle2 = new Circle(440,135,30, Color.LIGHTSKYBLUE);
		pcircle3 = new Circle(440,205,30, Color.LIGHTSKYBLUE);
		
		ptext1 = new Text(417,70,"Printer1");
		ptext2 = new Text(417,140,"Printer2");
		ptext3 = new Text(417,210,"Printer3");

		Group layout = new Group();
		layout.getChildren().addAll(button, ucircle1, ucircle2,ucircle3, ucircle4);
		layout.getChildren().addAll(utext1,utext2,utext3,utext4);
		layout.getChildren().addAll(dcircle1,dcircle2,dtext1,dtext2);
		layout.getChildren().addAll(pcircle1,pcircle2,pcircle3,ptext1,ptext2,ptext3);
		Scene scene = new Scene(layout, 500, 360);
		primaryStage.setScene(scene);
		
		primaryStage.show();
			
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource() == button)
		{
			os.run_OS();
		}
	}

	VBox create_UserVBox() 
	{	
		Circle circle1 = new Circle(60,50,30, Color.LIGHTSKYBLUE);
		Circle circle2 = new Circle(60,50,30,Color.LIGHTSKYBLUE);
		Circle circle3 = new Circle(60,50,30,Color.LIGHTSKYBLUE);
		Circle circle4 = new Circle(60,50,30,Color.LIGHTSKYBLUE);
		
		Text text1 = new Text("User 1");
		StackPane stack1 = new StackPane();
		stack1.getChildren().addAll(circle1, text1);
		
		Text text2 = new Text("User 2");
		StackPane stack2 = new StackPane();
		stack2.getChildren().addAll(circle2, text2);
		
		Text text3 = new Text("User 3");
		StackPane stack3 = new StackPane();
		stack3.getChildren().addAll(circle3, text3);
		
		Text text4 = new Text("User 4");
		StackPane stack4 = new StackPane();
		stack4.getChildren().addAll(circle4, text4);
		
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.getChildren().addAll(stack1, stack2, stack3, stack4);
		
		return vBox;
	}
	
	VBox create_PrinterVBox()
	{
		Circle circle1 = new Circle(60,50,30, Color.LIGHTPINK);
		Circle circle2 = new Circle(60,50,30,Color.LIGHTPINK);
		Circle circle3 = new Circle(60,50,30,Color.LIGHTPINK);
		
		Text text1 = new Text("Printer 1");
		StackPane stack1 = new StackPane();
		stack1.getChildren().addAll(circle1, text1);
		
		Text text2 = new Text("Printer 2");
		StackPane stack2 = new StackPane();
		stack2.getChildren().addAll(circle2, text2);
		
		Text text3 = new Text("Printer 3");
		StackPane stack3 = new StackPane();
		stack3.getChildren().addAll(circle3, text3);
		
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		
		
		vBox.getChildren().setAll(stack1, stack2, stack3);
		
		return vBox;
		
	}
	
	VBox create_diskVBox() {
		Circle circle1 = new Circle(60,50,30, Color.LIGHTGOLDENRODYELLOW);
		Circle circle2 = new Circle(60,50,30,Color.LIGHTGOLDENRODYELLOW);
		
		Text text1 = new Text("Disk 1");
		StackPane stack1 = new StackPane();
		stack1.getChildren().addAll(circle1, text1);
		
		Text text2 = new Text("Disk 2");
		StackPane stack2 = new StackPane();
		stack2.getChildren().addAll(circle2, text2);
		
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		
		
		vBox.getChildren().setAll(stack1, stack2);
		
		return vBox;
	}
	
	
	Text create_UserText(String userName) 
	{
		Text user = new Text(userName);
		user.setFont(Font.font("monaco"));
		return user;
	}
	
	Text create_PrinterText(String printerName)
	{
		Text user = new Text(printerName);
		user.setFont(Font.font("monaco"));
		return user;
	}
	
}