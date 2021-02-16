package Gas_Engineering

import static javax.swing.JOptionPane.*

class MainExecutor {

    static void main(String[] args) {
        //Execution starts here...
        showMessageDialog(null, '''Welcome to the Gas Well Performance and Flow Prediction Application
            \n\n\n\n\n\n\n\n\n\n\nPress OK to continue''', "PERFORMANCE/PREDICTION!", INFORMATION_MESSAGE)

        String[] choices = ["GAS_FLOW_RATE", "PRODUCTIVITY_INDEX", "SKIN_FACTOR", "FLOW_PREDICTION", "EXIT"]
        int chosen = showOptionDialog(null, "Please Choose the Calculation you wish to perform:\n\n\n\n\n\n\n",
                "Make a choice Now!", DEFAULT_OPTION, INFORMATION_MESSAGE, null, choices, choices[0])
        //Instantiate the ExecHelper class:
        ExecHelper execHelper = new ExecHelper()

        if (chosen == 0) {
            //compute Gas Flow Rate
            execHelper.gasFlowRate()
        } else if (chosen == 1) {
            //compute Productivity Index
            execHelper.prodIndex()
        } else if (chosen == 2) {
            //compute Skin Factor
            execHelper.skinFactor()
        } else if (chosen == 3) {
            //compute Flow Prediction
            execHelper.flowPrediction()
        } else {
            showMessageDialog(null, "Application about to exit. Thanks for using the Application", "GOODBYE!", WARNING_MESSAGE)
            System.exit(0)
        }
    }

}
