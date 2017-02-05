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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/** ===========================================================
 * sets the labels
 * ===========================================================
 */


public class MainController {
    @FXML
    Label lblCenter;
    @FXML
    Label lblEast;
    @FXML
    Label lblWest;
    @FXML
    Label lblNorth;
    @FXML
    Label lblSouth;
    @FXML
    Label lblNE;
    @FXML
    Label lblNW;
    @FXML
    Label lblSE;
    @FXML
    Label lblSW;
    @FXML
    TextField userMapsheet;


    /** ===========================================================
     * function for hte button
     * ===========================================================
     */


    @FXML
    public void mapLookUp() {

        int blockNumber;
        String blockLetter, blockNumberAsString;

        /** ===========================================================
         * Cuts user input into letters and numbers via string split
         * ===========================================================
         */
        TextField input = userMapsheet;

        blockNumberAsString = input.getText().substring(0, input.getText().length() - 1);
        blockNumber = Integer.parseInt(blockNumberAsString);
        blockLetter = input.getText().substring(input.getText().length() - 1);

        /** ===========================================================
         * sets the block numbers for each direction
         * ===========================================================
         */
        int westBlockNumber = Integer.parseInt(blockNumberAsString);
        int eastBlockNumber = Integer.parseInt(blockNumberAsString);
        int northBlockNumber = Integer.parseInt(blockNumberAsString);
        int southBlockNumber = Integer.parseInt(blockNumberAsString);
        int nWestBlockNumber = Integer.parseInt(blockNumberAsString);
        int nEastBlockNumber = Integer.parseInt(blockNumberAsString);
        int sWestBlockNumber = Integer.parseInt(blockNumberAsString);
        int sEastBlockNumber = Integer.parseInt(blockNumberAsString);

        /** ===========================================================
         * Calculates the new block number depending on where the map
         * sheet falls upon
         * ===========================================================
         */
        if (NTS.isWest(blockLetter)) {
            westBlockNumber = blockNumber + 10;
        }
        if (NTS.isEast(blockLetter)) {
            eastBlockNumber = blockNumber - 10;
        }
        if (NTS.isNorth(blockLetter)) {
            northBlockNumber = blockNumber + 1;
        }
        if (NTS.isSouth(blockLetter)) {
            southBlockNumber = blockNumber - 1;
        }
        if (NTS.isNorthWest(blockLetter)) {
            nWestBlockNumber = blockNumber + 11;
            nEastBlockNumber = blockNumber + 1;
            sWestBlockNumber = blockNumber + 10;
        }
        if (NTS.isNorthEast(blockLetter)) {
            nWestBlockNumber = blockNumber + 1;
            nEastBlockNumber = blockNumber - 9;
            sEastBlockNumber = blockNumber - 10;
        }
        if (NTS.isSouthWest(blockLetter)) {
            nWestBlockNumber = blockNumber + 10;
            sWestBlockNumber = blockNumber + 9;
            sEastBlockNumber = blockNumber - 1;
        }
        if (NTS.isSouthEast(blockLetter)) {
            nEastBlockNumber = blockNumber - 10;
            sWestBlockNumber = blockNumber - 1;
            sEastBlockNumber = blockNumber - 11;
        }

        /** ===========================================================
         * Calls an argument from mapsheetIndexOf method
         * ===========================================================
         */
        int position = NTS.mapsheetIndexOf(blockLetter);


        /** ===========================================================
         * Finds mapsheet letter in a 2d array
         * ===========================================================
         */
        String westMapSheets = NTS.adjMapLetters[position][NTS.WEST];
        String eastMapSheets = NTS.adjMapLetters[position][NTS.EAST];
        String northMapSheets = NTS.adjMapLetters[position][NTS.NORTH];
        String southMapSheets = NTS.adjMapLetters[position][NTS.SOUTH];
        String nWestMapSheets = NTS.adjMapLetters[position][NTS.NORTHWEST];
        String nEastMapSheets = NTS.adjMapLetters[position][NTS.NORTHEAST];
        String sWestMapSheets = NTS.adjMapLetters[position][NTS.SOUTHWEST];
        String sEastMapSheets = NTS.adjMapLetters[position][NTS.SOUTHEAST];

        /** ===========================================================
         * concat the numbers and letters together
         * ===========================================================
         */
        String w = String.format("%04d", westBlockNumber) + westMapSheets;
        String e = String.format("%04d", eastBlockNumber) + eastMapSheets;
        String n = String.format("%04d", northBlockNumber) + northMapSheets;
        String s = String.format("%04d", southBlockNumber) + southMapSheets;
        String nw = String.format("%04d", nWestBlockNumber) + nWestMapSheets;
        String ne = String.format("%04d", nEastBlockNumber) + nEastMapSheets;
        String sw = String.format("%04d", sWestBlockNumber) + sWestMapSheets;
        String se = String.format("%04d", sEastBlockNumber) + sEastMapSheets;
        String c = String.format("%04d", blockNumber) + blockLetter.toUpperCase();

        /** ===========================================================
         * The following block sets the app text
         * ===========================================================
         */

        lblCenter.setText(c);
        lblWest.setText(w);
        lblEast.setText(e);
        lblNorth.setText(n);
        lblSouth.setText(s);

        lblNE.setText(ne);
        lblNW.setText(nw);
        lblSE.setText(se);
        lblSW.setText(sw);
    }

    @FXML
    public void clickValue(MouseEvent e) {

        /** ===========================================================
         * The following block does ....
         * ===========================================================
         */


        Label lblClick = (Label) e.getSource();
        userMapsheet.setText(lblClick.getText());
        mapLookUp();
    }

}
