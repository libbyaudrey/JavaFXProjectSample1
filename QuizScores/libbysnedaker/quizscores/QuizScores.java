//Libby Snedaker July 29, 2019
package libbysnedaker.quizscores;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuizScores extends Application {
	
	//grade data that is hard coded and can be changed manually in the code
	private static final double A_COUNT = 10; //blueviolet
	private static final double B_COUNT = 25; //darkcyan
	private static final double C_COUNT = 45; //darkseagreen
	private static final double D_COUNT = 7; //deeppink
	private static final double F_COUNT = 13; //rosybrown
	private static final double TOTAL_COUNT = (A_COUNT + B_COUNT + C_COUNT + D_COUNT + F_COUNT);

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create font object w/specific font type and size
		Font myFont = new Font ("Times New Roman", 22);
		
		//create arcs (5)
		//each arc starts where the previous arc ends
		//arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
		
		//variable to be updated each time to make code more concise
		double currentStartingPos = 0;
		
		Arc arc1 = new Arc(300, 300, 150, 150, currentStartingPos, ((A_COUNT/TOTAL_COUNT)*360));
		arc1.setType(ArcType.ROUND);
		arc1.setFill(Color.BLUEVIOLET);
		
		currentStartingPos = (currentStartingPos + ((A_COUNT/TOTAL_COUNT)*360));
		
		Arc arc2 = new Arc(300, 300, 150, 150, currentStartingPos, ((B_COUNT/TOTAL_COUNT)*360));
		arc2.setType(ArcType.ROUND);
		arc2.setFill(Color.DARKCYAN);
		
		currentStartingPos = (currentStartingPos + ((B_COUNT/TOTAL_COUNT)*360));
		
		Arc arc3 = new Arc(300, 300, 150, 150, currentStartingPos, ((C_COUNT/TOTAL_COUNT)*360));
		arc3.setType(ArcType.ROUND);
		arc3.setFill(Color.DARKSEAGREEN);
		
		currentStartingPos = (currentStartingPos + ((C_COUNT/TOTAL_COUNT)*360));
		
		Arc arc4 = new Arc(300, 300, 150, 150, currentStartingPos, ((D_COUNT/TOTAL_COUNT)*360));
		arc4.setType(ArcType.ROUND);
		arc4.setFill(Color.DEEPPINK);
		
		currentStartingPos = (currentStartingPos + ((D_COUNT/TOTAL_COUNT)*360));
		
		Arc arc5 = new Arc(300, 300, 150, 150, currentStartingPos, ((F_COUNT/TOTAL_COUNT)*360));
		arc5.setType(ArcType.ROUND);
		arc5.setFill(Color.ROSYBROWN);
		
		//format percentage of grades
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMaximumFractionDigits(0);
		
		//labels for legend in FlowPane
		Label gradeA = new Label (percentFormat.format(A_COUNT/TOTAL_COUNT) + "-A" + "   ");
		gradeA.setFont(myFont);
		gradeA.setTextFill(Color.BLUEVIOLET);
		Label gradeB = new Label(percentFormat.format(B_COUNT/TOTAL_COUNT) + "-B" + "   ");
		gradeB.setFont(myFont);
		gradeB.setTextFill(Color.DARKCYAN);
		Label gradeC = new Label (percentFormat.format(C_COUNT/TOTAL_COUNT) + "-C" + "   ");
		gradeC.setFont(myFont);
		gradeC.setTextFill(Color.DARKSEAGREEN);
		Label gradeD = new Label (percentFormat.format(D_COUNT/TOTAL_COUNT) + "-D" + "   ");
		gradeD.setFont(myFont);
		gradeD.setTextFill(Color.DEEPPINK);
		Label gradeF = new Label (percentFormat.format(F_COUNT/TOTAL_COUNT) + "-F" + "   ");
		gradeF.setFont(myFont);
		gradeF.setTextFill(Color.ROSYBROWN);
		
		//flowPane with 4 label objects will be in bottom region of BorderPane
		FlowPane theFP = new FlowPane();
		theFP.setPadding(new Insets(5));
		theFP.getChildren().addAll(gradeA, gradeB, gradeC, gradeD, gradeF);
		
		//label object for chart title in top region of BorderPane
		Label titleLabel = new Label("Percent of Quiz Scores by Grade");
		titleLabel.setFont(myFont);
		
		//the BorderPane
		BorderPane thePane = new BorderPane();
		thePane.setTop(titleLabel);
		BorderPane.setAlignment(titleLabel, Pos.TOP_CENTER);
		thePane.getChildren().addAll(arc1, arc2, arc3, arc4, arc5);
		thePane.setBottom(theFP);
		BorderPane.setAlignment(theFP, Pos.BOTTOM_LEFT);
		
		//the scene
		Scene scene1 = new Scene(thePane, 600, 600);	
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Quiz Score Analysis");
		primaryStage.show();

	}

}
