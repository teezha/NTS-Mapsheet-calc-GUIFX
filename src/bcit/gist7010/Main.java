package bcit.gist7010;

/** ==============================================================================
 * File         : some_file.java
 *
 * Current Author: Robert Hewlett
 *
 * Previous Author: None
 *
 * Contact Info: somebody@somewhere.com
 *
 * Purpose :
 *
 * Dependencies: None
 *
 * Modification Log :
 *    --> Created MMM-DD-YYYY (fl)
 *    --> Updated MMM-DD-YYYY (fl)
 *
 * =============================================================================
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** ===========================================================
 * The following block does ....
 * ===========================================================
 */


public class Main extends Application {

    /** ===========================================================
     * App launch
     * ===========================================================
     */


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainController.fxml"));
        primaryStage.setTitle("NTS Sheets");
        primaryStage.setScene(new Scene(root, 470, 520));
        primaryStage.show();
    }

    /** ===========================================================
     * App launch that does a check
     * ===========================================================
     */



    public static void main(String[] args) {
        launch(args);
    }
}
