package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // To-Do Top Description
        Text toDoText = new Text("To-Do List");
        toDoText.setFont(new Font("Verdana", 20));
        toDoText.setFill(Color.BLACK);

        // Labels & TextField controls
        Label enterTaskLabel = new Label("Enter a Task: ");
        TextField enterTaskTextField = new TextField();

        // Enter Task controls
        HBox enterTaskHBox = new HBox(10,enterTaskLabel, enterTaskTextField);
        enterTaskHBox.setAlignment(Pos.CENTER);
        enterTaskHBox.setPadding(new Insets(10));

        // ts Label
        Label timeSensitiveLabel = new Label("Time Sensitive");

        // ts controls
        RadioButton timeSensitiveButton = new RadioButton("Time Sensitive");
        RadioButton notTimeSensitiveButton = new RadioButton("Not Time Sensitive");
        notTimeSensitiveButton.setSelected(true);      // Not Time Sensitive by default

        ToggleGroup timeSensitiveToggleGroup = new ToggleGroup();
        timeSensitiveButton.setToggleGroup(timeSensitiveToggleGroup);
        notTimeSensitiveButton.setToggleGroup(timeSensitiveToggleGroup);

        HBox timeSensitiveControlsHBox = new HBox(10, timeSensitiveButton, notTimeSensitiveButton);
        timeSensitiveControlsHBox.setAlignment(Pos.CENTER);
        timeSensitiveControlsHBox.setPadding(new Insets(10));

        // ts main view
        VBox timeSensitiveMainVBox = new VBox(5, timeSensitiveLabel, timeSensitiveControlsHBox);
        timeSensitiveMainVBox.setAlignment(Pos.CENTER);
        timeSensitiveMainVBox.setPadding(new Insets(10));


        // LOI Label
        Label levelOfImportanceLabel = new Label("Level of Importance");

        // LOI controls
        RadioButton lowButton = new RadioButton("Low");
        lowButton.setSelected(true);  // Low is default
        RadioButton mediumButton = new RadioButton("Medium");
        RadioButton highButton = new RadioButton("High");

        ToggleGroup levelOfImportanceToggleGroup = new ToggleGroup();
        lowButton.setToggleGroup(levelOfImportanceToggleGroup);
        mediumButton.setToggleGroup(levelOfImportanceToggleGroup);
        highButton.setToggleGroup(levelOfImportanceToggleGroup);


        // LOI controls
        HBox levelOfImportanceControlsHBox = new HBox(10, lowButton, mediumButton, highButton);
        levelOfImportanceControlsHBox.setAlignment(Pos.CENTER);
        levelOfImportanceControlsHBox.setPadding(new Insets(10));

        // LOI main view
        VBox levelOfImportanceMainVBox = new VBox(5, levelOfImportanceLabel, levelOfImportanceControlsHBox);
        levelOfImportanceMainVBox.setAlignment(Pos.CENTER);
        levelOfImportanceMainVBox.setPadding(new Insets(10));


        // Java Map / Collection cheat sheet says use TreeMap
        // Map<Integer, List<Task>> userToDoList = new TreeMap<Integer, List<Task>>();

        // Text used for To-Do display
        Text toDoDisplayText = new Text();


        // List for Tasks
        List<Task> theTaskList = new LinkedList<Task>();

        // Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e->
        {
            // Store user input
            String userTaskDisc = enterTaskTextField.getText();

            // time sensitive control
            boolean isTimeSensitive;
            if(timeSensitiveButton.isSelected())
            {
                 isTimeSensitive = true;
            }
            else
            {
                isTimeSensitive = false;
            }


            // level of importance controls
            String loi;
            if(lowButton.isSelected())
            {
                loi = "Low";
            }
            else if(mediumButton.isSelected())
            {
                loi = "Medium";
            }
            else if(highButton.isSelected())
            {
                loi = "High";
            }
            else
            {
                loi = "Low";
            }


            // Create Task
            Task userTask = new Task(userTaskDisc, isTimeSensitive, loi );
            // Add to List
            theTaskList.add(userTask);
            // Sort, reverse, display
            Collections.sort(theTaskList);
            Collections.reverse(theTaskList);

            Iterator<Task> itr = theTaskList.iterator();

            int counter = 1;
            String listSringAccumulator = "";

            while(itr.hasNext())
            {
                listSringAccumulator += counter + ": " + itr.next() + "\n";
                counter++;
            }

            // Display List values
            toDoDisplayText.setText(listSringAccumulator);


            // Reset accumulator and controls
            counter = 1;
            enterTaskTextField.setText("");
            notTimeSensitiveButton.setSelected(true);
            lowButton.setSelected(true);
        });



        // Button & Event Handling
        Button printButton = new Button("Print");
        printButton.setOnAction(e->
        {


        });

        // HBox buttonH = new HBox(5,submitButton, );

        // Main container
        VBox mainContainer = new VBox(10, toDoText, enterTaskHBox, timeSensitiveMainVBox, levelOfImportanceMainVBox, submitButton, toDoDisplayText);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(10));

        // Scene
        Scene scene = new Scene(mainContainer, 500, 500);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chapter 21 Problem 1");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
