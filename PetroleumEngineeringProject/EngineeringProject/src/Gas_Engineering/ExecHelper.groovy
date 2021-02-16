package Gas_Engineering

import PressureRegion.*
import FlowRate.*

import javax.swing.JTextField

import static javax.swing.JOptionPane.*
/*import static javax.swing.JOptionPane.DEFAULT_OPTION
import static javax.swing.JOptionPane.INFORMATION_MESSAGE
import static javax.swing.JOptionPane.OK_CANCEL_OPTION
import static javax.swing.JOptionPane.OK_OPTION
import static javax.swing.JOptionPane.WARNING_MESSAGE
import static javax.swing.JOptionPane.YES_NO_OPTION
import static javax.swing.JOptionPane.showConfirmDialog
import static javax.swing.JOptionPane.showMessageDialog
import static javax.swing.JOptionPane.showOptionDialog*/

class ExecHelper implements GasFlowRate, ProductivityIndex, SkinFactor, FlowRate{

    def gasFlowRate = {
        showMessageDialog(null, "You have Chosen the Gas Flow Rate Calculation!", "GAS FLOW RATE SELECTED", INFORMATION_MESSAGE)
        String[] GFRchoices = ["GENERAL", "HIGH", "LOW"]
        int GFRchosen = showOptionDialog(null, "Sorry to bother you...\nBut you have to choose among the Gas Flow Rate Computation Choices\n\n\n\n\n\n",
                "Make a choice Now!", DEFAULT_OPTION, INFORMATION_MESSAGE, null, GFRchoices, GFRchoices[0])

        switch (GFRchosen) {

            case 0://general perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPseudo = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField temp = new JTextField("Temperature here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField skinFac = new JTextField("Skin Factor for general here")

                Object[] options = [perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac]
                showMessageDialog(null, "INSTRUCTION:\nSupply all integer whole number values as decimal i.e 2 as 2.0 in the parameters")

                int computeCommand = showConfirmDialog(null, options, "GAS FLOW RATE - GENERAL PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters inputed previously will be used to compute \nthe Gas Flow Rate at General Pressure Point\n\n")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def GFRgeneral = this.GFRgeneral(perm.text as Double, thick.text as Double, avrPseudo.text as Double, avrWellFactor.text as Double, temp.text as Double, drainRad.text as Double, wellBoreRad.text as Double, skinFac.text as Double)
                        showMessageDialog(null, "Gas Flow Rate for General Pressure Point Successful \n\n\nThe derived gas flow rate at Mscf/day is: ${GFRgeneral}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        int yes_no = showConfirmDialog(null, "Do you want to continue to the alternative computation of Gas Flow Rate at General Pressure Point?\n\n", "HEY!, WANNA CONTINUE?", YES_NO_OPTION)

                        if (yes_no == YES_OPTION) {
                            JTextField genProdIndex = new JTextField("Production Index for General Pressure Point ")
                            JTextField avrPseudoAlt = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                            JTextField avrWellFactorAlt = new JTextField("Average Well Flowing Pressure")

                            Object[] optionsAlt = [genProdIndex, avrPseudoAlt, avrWellFactorAlt]
                            showMessageDialog(null, "Welcome to the alternative computation of Gas Flow Rate at General Pressure Point.")
                            showMessageDialog(null, "INSTRUCTION:\nSupply all integer whole number values as decimal i.e 2 as 2.0 in the parameters")

                            int chooseAlt = showConfirmDialog(null, optionsAlt, "GAS FLOW RATE ALTERNATIVE - GENERAL PRESSURE REGION", YES_NO_OPTION)
                            showMessageDialog(null, "\nThe supplied gas parameters obtained previously will be used to compute\nthe flow rate at general pressure point")
                            if (chooseAlt == YES_OPTION) {
                                def GFRgeneralAlt = this.GFRgeneralAlt(genProdIndex.text as Double, avrPseudoAlt.text as Double, avrWellFactorAlt.text as Double)
                                showMessageDialog(null, "Gas Flow Rate for General Pressure Point Successful \n\n\nThe derived gas flow rate at Mscf/day is: ${GFRgeneralAlt}",
                                        "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                                showMessageDialog(null, "Computation Performed!,\n ...Exiting Now..Thanks for using the application", "APP TO EXIT", INFORMATION_MESSAGE)
                                System.exit(0)
                            } else {
                                showMessageDialog(null, "Apparently, you dont want to continue...." +
                                        "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                                System.exit(0)
                            }
                        } else {
                            showMessageDialog(null, "Apparently, you dont want to continue...." +
                                    "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                            System.exit(0)
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        //showConfirmDialog(null, "Do you want to continue to the alternative computation of General Gas Flow?")
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break


            case 1://high perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Gas Formation Volume Factor ")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField skinFac = new JTextField("Skin Factor for general here")

                Object[] options = [perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad, skinFac]
                 showMessageDialog(null, "INSTRUCTION: \n\n Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "GAS FLOW RATE - HIGH PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters above will be used to compute \nthe Gas Flow Rate at High Pressure Point")
                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def GFRhigh = this.GFRhigh(perm.text as Double, thick.text as Double, avrPressure.text as Double, avrPressureWellFactor.text as Double, gasViscosity.text as Double,
                                formVolFac.text as Double, drainRad.text as Double, wellBoreRad.text as Double, skinFac.text as Double)
                        showMessageDialog(null, "Gas Flow Rate for High Pressure Point Successful \n\n\nThe derived gas flow rate at Mscf/day is: ${GFRhigh}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        int yes_no = showConfirmDialog(null, "Do you want to continue to the alternative computation of Gas Flow Rate at High Pressure Point?\n\n", "HEY!, WANNA CONTINUE?", YES_OPTION)

                        if (yes_no) {
                            showMessageDialog(null, "Sorry, but there is no alternative Gas Flow Rate computation for High Pressure Point" +
                                    "\n ..System about to exit", "NO ALTERNATIVE!", WARNING_MESSAGE)
                            System.exit(0)
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break


            case 2://low perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField temp = new JTextField("Temperature here")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField gasCompressFac = new JTextField("Gas compressibity Factor")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField skinFac = new JTextField("Skin Factor for general here")

                Object[] options = [perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac]
                showMessageDialog( null, "INSTRUCTION: \nSupply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "GAS FLOW RATE - GENERAL LOW REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters above obtained previously will be used to compute \nthe flow rate at low pressure point")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def GFRlow = this.GFRlow(perm.text as Double, thick.text as Double, avrPressure.text as Double, avrPressureWellFactor.text as Double, temp.text as Double,
                                gasViscosity.text as Double, gasCompressFac.text as Double, drainRad.text as Double, wellBoreRad.text as Double, skinFac.text as Double)
                        showMessageDialog(null, "Gas Flow Rate for General Pressure Point Successful \n\n\nThe derived gas flow rate at Mscf/day is: ${GFRlow}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        int yes_no = showConfirmDialog(null, "Do you want to continue to the alternative computation of Gas Flow Rate at General Pressure Point?\n\n", "HEY!, WANNA CONTINUE?", YES_NO_OPTION)

                        if (yes_no == YES_OPTION) {//lowProIndex, avrPressure, avrPressureWellFactor
                            JTextField lowProdIndex = new JTextField("Production Index for General Pressure Point ")
                            JTextField avrPressureAlt = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                            JTextField avrPressureWellFactorAlt = new JTextField("Average Well Flowing Pressure")

                            Object[] optionsAlt = [lowProdIndex, avrPressureAlt, avrPressureWellFactorAlt]
                            showMessageDialog(null, "Welcome to the alternative computation of Gas Flow Rate at Low Pressure Point.")

                            int chooseAlt = showConfirmDialog(null, optionsAlt, "GAS FLOW RATE ALTERNATIVE - LOW PRESSURE REGION", YES_NO_OPTION)
                            showMessageDialog(null, "\n The supplied gas parameters previously obtained will be used to compute\nthe Flow Rate at Low Pressure Point")
                            if (chooseAlt == YES_OPTION) {
                                def GFRlowAlt = this.GFRlowAlt(lowProdIndex.text as Double, avrPressureAlt.text as Double, avrPressureWellFactorAlt.text as Double)
                                showMessageDialog(null, "Gas Flow Rate for Low Pressure Point Successful \n\n\nThe derived gas flow rate at Mscf/day is: ${GFRlowAlt}",
                                        "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                                showMessageDialog(null, "Computation Performed!,\n ...Exiting Now..Thanks for using the application", "APP TO EXIT", INFORMATION_MESSAGE)
                                System.exit(0)
                            } else {
                                showMessageDialog(null, "Apparently, you don't want to continue...." +
                                        "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                                System.exit(0)
                            }
                        } else {
                            showMessageDialog(null, "Apparently, you don't want to continue...." +
                                    "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                            System.exit(0)
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        //showConfirmDialog(null, "Do you want to continue to the alternative computation of General Gas Flow?")
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
        }

    }


    def prodIndex = {
        showMessageDialog(null, "You have Chosen the Productivity Index Calculation!", "PRODUCTIVITY INDEX SELECTED", INFORMATION_MESSAGE)
        String[] PIchoices = ["GENERAL", "HIGH", "LOW"]
        int PIchosen = showOptionDialog(null, "Sorry to bother you...\nBut you have to choose among the Gas Flow Rate Computation Choices\n\n\n\n\n\n",
                "Make a choice Now!", DEFAULT_OPTION, INFORMATION_MESSAGE, null, PIchoices, PIchoices[0])

        switch (PIchosen) {

            case 0://general perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPseudo = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField temp = new JTextField("Temperature here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField skinFac = new JTextField("Skin Factor for general here")

                Object[] options = [perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac]
                showMessageDialog( null, "INSTRUCTION:\nSupply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "PRODUCTIVITY INDEX - GENERAL PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters above will be used to compute \nthe Productivity Index at General Pressure Point")


                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def PIgeneral = this.PIgeneral(perm.text as Double, thick.text as Double, avrPseudo.text as Double, avrWellFactor.text as Double,
                                temp.text as Double, drainRad.text as Double, wellBoreRad.text as Double, skinFac.text as Double)
                        showMessageDialog(null, "Productivity Index for General Pressure Point Successful \n\n\nThe derived Productivity Index is: ${PIgeneral}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        int yes_no = showConfirmDialog(null, "Do you want to continue to the alternative computation of Productivity Index at General Pressure Point?\n\n", "HEY!, WANNA CONTINUE?", YES_NO_OPTION)

                        if (yes_no == YES_OPTION) {//GFRgeneral, avrPseudo, avrWellFactor
                            JTextField genGFR = new JTextField("Gas Flow Rate for General Pressure Point ")
                            JTextField avrPseudoAlt = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                            JTextField avrWellFactorAlt = new JTextField("Average Well Flowing Pressure")

                            Object[] optionsAlt = [genGFR, avrPseudoAlt, avrWellFactorAlt]
                            showMessageDialog(null, "Welcome to the alternative computation of Productivity Index at General Pressure Point.")
                            showMessageDialog( null, "INSTRUCTION:\nSupply all integer values as decimal i.e 2 as 2.0")

                            int chooseAlt = showConfirmDialog(null, optionsAlt, "PRODUCTIVITY INDEX ALTERNATIVE - GENERAL PRESSURE REGION", YES_NO_OPTION)
                            showMessageDialog(null, "\n\n The supplied gas parameters above will be used to compute\n" +
                                    "the productivity Index at General Pressure Point")

                            if (chooseAlt == YES_OPTION) {
                                def PIgenAlt = this.PIgenAlt(genGFR.text as Double, avrPseudoAlt.text as Double, avrWellFactorAlt.text as Double)
                                showMessageDialog(null, "Productivity Index for General Pressure Point Successful \n\n\nThe derived Productivity Index  is: ${PIgenAlt}",
                                        "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                                showMessageDialog(null, "Computation Performed!,\n ...Exiting Now..Thanks for using the application", "APP TO EXIT", INFORMATION_MESSAGE)
                                System.exit(0)
                            } else {
                                showMessageDialog(null, "Apparently, you dont want to continue...." +
                                        "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                                System.exit(0)
                            }
                        } else {
                            showMessageDialog(null, "Apparently, you dont want to continue...." +
                                    "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                            System.exit(0)
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Productivity Index Computation Failure", WARNING_MESSAGE)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break


            case 1://high
                showMessageDialog(null, "OOps! No computation exist for Productivity Index at High Pressure Point!", "NO_COMPUTATION_EXIST", WARNING_MESSAGE)
                System.exit(0)
                break


            case 2://low perm, thick, temp, avrPressure, avrPressureWellFactor, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField temp = new JTextField("Temperature here")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField gasCompressFac = new JTextField("Gas compressibity Factor")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField skinFac = new JTextField("Skin Factor for general here")

                Object[] options = [perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac]
                showMessageDialog(null, "INSTRUCTION: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "PRODUCTIVITY INDEX - LOW PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters previously obtained will be used to compute \nthe productivity Index at low pressure point")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def PIlow = this.PIlow(perm.text as Double, thick.text as Double, avrPressure.text as Double, avrPressureWellFactor.text as Double, temp.text as Double,
                                gasViscosity.text as Double, gasCompressFac.text as Double, drainRad.text as Double, wellBoreRad.text as Double, skinFac.text as Double)
                        showMessageDialog(null, "Productivity Index for Low Pressure Point Successful \n\n\nThe derived Productivity Index is: ${PIlow}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        int yes_no = showConfirmDialog(null, "Do you want to continue to the alternative computation of Productivity Index at Low Pressure Point?\n\n", "HEY!, WANNA CONTINUE?", YES_NO_OPTION)

                        if (yes_no == YES_OPTION) {//GFRlow, avrPressure, avrPressureWellFactor
                            JTextField GFRlow = new JTextField("Gas Flow Rate for General Pressure Point")
                            JTextField avrPressureAlt = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                            JTextField avrPressureWellFactorAlt = new JTextField("Average Well Flowing Pressure")

                            Object[] optionsAlt = [GFRlow, avrPressureAlt, avrPressureWellFactorAlt]
                            showMessageDialog(null, "Welcome to the alternative computation of Productivity Index at Low Pressure Point.")
                            showMessageDialog(null, "INSTRUCTION: Supply all integer values as decimal i.e 2 as 2.0")

                            int chooseAlt = showConfirmDialog(null, optionsAlt, "PRODUCTIVITY INDEX ALTERNATIVE - LOW PRESSURE REGION", YES_NO_OPTION)
                            showMessageDialog(null, "\nThe supplied gas parameters above will be used to compute\nthe Productivity Index at Low Pressure Point")

                            if (chooseAlt == YES_OPTION) {
                                def PIlowAlt = this.PIlowAlt(GFRlow.text as Double, avrPressureAlt.text as Double, avrPressureWellFactorAlt.text as Double)
                                showMessageDialog(null, "Productivity Index for Low Pressure Point Successful \n\n\nThe derived productivity Index is: ${PIlowAlt}",
                                        "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                                showMessageDialog(null, "Computation Performed!,\n ...Exiting Now..Thanks for using the application", "APP TO EXIT", INFORMATION_MESSAGE)
                                System.exit(0)
                            } else {
                                showMessageDialog(null, "Apparently, you don't want to continue...." +
                                        "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                                System.exit(0)
                            }
                        } else {
                            showMessageDialog(null, "Apparently, you don't want to continue...." +
                                    "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                            System.exit(0)
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Productivity Index Computation Failure", WARNING_MESSAGE)
                        //showConfirmDialog(null, "Do you want to continue to the alternative computation of ?")
                        showMessageDialog(null, "\n\n Exiting the System Now..Thanks for using the Application",
                                "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
        }

    }


    def skinFactor = {
        showMessageDialog(null, "You have Chosen the Skin Factor Calculation!", "SKIN FACTOR SELECTED", INFORMATION_MESSAGE)
        String[] SFchoices = ["UNIVERSAL", "NORMAL", "GENERAL", "HIGH", "LOW"]
        int SFchosen = showOptionDialog(null, "Sorry to bother you...\nBut you have to choose among the Gas Flow Rate Computation Choices\n\n\n\n\n\n",
                "Make a choice Now!", DEFAULT_OPTION, INFORMATION_MESSAGE, null, SFchoices, SFchoices[0])

        switch (SFchosen) {

            case 0://Universal perm, permDueToSkin, damageRad, wellBoreRad
                //Prompt the user to enter appropriate parameters:
                JTextField perm = new JTextField("Permeability, K here")
                JTextField permDueToSkin = new JTextField("Permeability due to skin here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")

                Object[] options = [perm, permDueToSkin, drainRad, wellBoreRad]
                showMessageDialog(null, "NB: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "SKIN FACTOR - UNIVERSAL PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters above will be used to compute \nthe Skin Factor at Universal pressure point")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def SFuniversal = this.SkinFactorUniversal(perm.text as Double, permDueToSkin.text as Double, drainRad.text as Double, wellBoreRad.text as Double) as Map
                        showMessageDialog(null, "Skin Factor for Universal Pressure Region Successful" +
                                "\n\n\nThe derived Universal Pressure Point is: ${SFuniversal["SFgenValue"]}" + "\n\n The state of the region is : ${SFuniversal["SFgenState"]}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        showMessageDialog(null, "Thanks for using the Application", "ABOUT TO EXIT", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch(Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break

        //"UNIVERSAL","NORMAL", "GENERAL", "HIGH", "LOW"
            case 1://normal: NormalFlowRate, gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad
                //Prompt the user to enter appropriate parameters:
                JTextField NormalFlowRate = new JTextField("Normal Flow Rate here")
                JTextField gasPerm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Gas Formation Volume Factor ")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")


                Object[] options = [NormalFlowRate, gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad]
                showMessageDialog(null, "INSTRUCTION: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "SKIN FACTOR - NORMAL PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters previously obtained will be used to compute \nthe Skin Factor at Normal Pressure Region")
                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def SFnormal = this.SkinFactorFromFlowPrediction(NormalFlowRate.text as Double, gasPerm.text as Double, thick.text as Double, avrPressure.text as Double,
                                avrPressureWellFactor.text as Double, gasViscosity.text as Double, formVolFac.text as Double,
                                drainRad.text as Double, wellBoreRad.text as Double) as Map
                        showMessageDialog(null, "Skin Factor for Normal Pressure Point Successful" +
                                "\n\n\nThe derived Skin Factor for Normal Flow Rate is: ${SFnormal["SFgenValue"]}" +
                                "\n\n The state of the region is : ${SFnormal["SFgenState"]}", "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        showMessageDialog(null, "Thanks for Using this Application, About to exit now", "EXIT", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break

            case 2://general GFRgeneral, perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad
                //Prompt the user to enter appropriate parameters:
                JTextField GFRgeneral = new JTextField("Gas Flow Rate at general point here")
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPseudo = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField temp = new JTextField("Temperature here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")


                Object[] options = [GFRgeneral, perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad]
                showMessageDialog(null,"INSTRUCTION: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "SKIN FACTOR - GENERAL PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "\nThe supplied gas parameters previously obtained will be used to compute \nthe Skin Factor at general pressure Region")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def SFgeneral = this.SkinFactorGeneral(GFRgeneral.text as Double, perm.text as Double, thick.text as Double, avrPseudo.text as Double,
                                avrWellFactor.text as Double, temp.text as Double, drainRad.text as Double, wellBoreRad.text as Double) as Map
                        showMessageDialog(null, "Skin Factor for General Pressure Point Successful \n\n\nThe derived Skin Factor is: ${SFgeneral["SFgenValue"]}" +
                                "\n\n The state of the region is : ${SFgeneral["SFgenState"]}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)

                        showMessageDialog(null, "Apparently, you don't want to continue...." +
                                "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)


                        showMessageDialog(null, "Apparently, you don't want to continue...." +
                                "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Skin Computation Error", WARNING_MESSAGE)
                        //showConfirmDialog(null, "Do you want to continue to the alternative computation of General Gas Flow?")
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
            case 3://high GFRhigh, perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad
                //Prompt the user to enter appropriate parameters:
                JTextField GFRhigh = new JTextField("Gas Flow Rate at High Pressure Region")
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Formation Volume Factor here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")


                Object[] options = [GFRhigh, perm, thick, avrPressure, avrWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad]
                showMessageDialog(null, "NB: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "SKIN FACTOR - HIGH PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters previously obtained will be used to compute \nthe Skin Factor at high pressure Region")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def SFhigh = this.SkinFactorHigh(GFRhigh.text as Double, perm.text as Double, thick.text as Double, avrPressure.text as Double,
                                avrWellFactor.text as Double, gasViscosity.text as Double, formVolFac.text as Double,
                                drainRad.text as Double, wellBoreRad.text as Double) as Map
                        showMessageDialog(null, "Skin Factor for High Pressure Point Successful \n\n\nThe derived Skin Factor is: ${SFhigh["SFgenValue"]}" + "\n\n The state of the region is : ${SFhigh["SFgenState"]}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)

                        showMessageDialog(null, "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)

                        showMessageDialog(null, "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Skin Computation Error", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
            case 4: //low:GFRlow, perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac
                //Prompt the user to enter appropriate parameters:
                JTextField GFRlow = new JTextField("Gas Flow Rate at High Pressure Region")
                JTextField perm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Formation Volume Factor here")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")

                Object[] options = [GFRlow, perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad]
                showMessageDialog(null, "INSTRUCTION: Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "SKIN FACTOR - LOW PRESSURE REGION", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters previously obtained will be used to compute \nthe Skin Factor at low pressure Region")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def SFlow = this.SkinFactorHigh(GFRlow.text as Double, perm.text as Double, thick.text as Double, avrPressure.text as Double,
                                avrPressureWellFactor.text as Double, gasViscosity.text as Double,
                                formVolFac.text as Double, drainRad.text as Double, wellBoreRad.text as Double) as Map
                        showMessageDialog(null, "Skin Factor for High Pressure Point Successful \n\n\nThe derived Skin Factor is: ${SFlow["SFgenValue"]}" + "\n\n The state of the region is : ${SFlow["SFgenState"]}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)

                        showMessageDialog(null, "\n\n Exiting the System Now..Thanks for using the Application", "APP TO EXIT!", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Skin Computation Error", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
        }

    }

    
    def flowPrediction = {
        showMessageDialog(null, "You have Chosen the FlowRate Prediction Calculation", "FLOWRATE PREDICTION SELECTED", INFORMATION_MESSAGE)
        String[] FPchoices = ["PAST", "PRESENT", "FUTURE"]
        int FPchosen = showOptionDialog(null, "Sorry to bother you...\nBut you have to choose among the Gas Flow Rate Computation Choices\n\n\n\n\n\n",
                "Make a choice Now!", DEFAULT_OPTION, INFORMATION_MESSAGE, null, FPchoices, FPchoices[0])

        switch (FPchosen) {

            case 0://Normal gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad, scaleFactor
                //Prompt the user to enter appropriate parameters:

                JTextField gasPerm = new JTextField("Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressure = new JTextField("Average Reservoir Real Gas Pseudo-Pressure")
                JTextField avrPressureWellFactor = new JTextField("Average Well Flowing Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Gas Formation Volume Factor")
                JTextField drainRad = new JTextField("Drainage Radius here")
                JTextField wellBoreRad = new JTextField("WellBore Radius here")
                JTextField scaleFactor = new JTextField("Scale Factor here")

                Object[] options = [gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad, scaleFactor]
                showMessageDialog(null, "Supply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "NORMAL FLOW RATE", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters above will be used \nto compute the Universal/Normal FlowRate")

                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def FRnormal = this.NormalFlowRate(gasPerm.text as Double, thick.text as Double, avrPressure.text as Double,
                                avrPressureWellFactor.text as Double, gasViscosity.text as Double,
                                formVolFac.text as Double, drainRad.text as Double, wellBoreRad.text as Double, scaleFactor.text as Double)
                        showMessageDialog(null, "Skin Factor for Universal Pressure Region Successful \n\n\nThe derived Universal Pressure Point is: ${FRnormal}",
                                "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        showMessageDialog(null, "Thanks for using the Application", "ABOUT TO EXIT", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break


            case 1://present: GasPermPresent, perm, thick, avrPressurePresent, gasViscosity, formVolFac
                //Prompt the user to enter appropriate parameters:
                JTextField gasPermPresent = new JTextField("Permeability, K for Present Flow here")
                JTextField gasPermNormal = new JTextField("Universal Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressurePresent = new JTextField("Average Reservoir Present Real Gas Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Gas Formation Volume Factor ")

                Object[] options = [gasPermPresent, gasPermNormal, thick, avrPressurePresent, gasViscosity, formVolFac]
                showMessageDialog(null, "INSTRUCTION: \nSupply all integer values as decimal i.e 2 as 2.0")


                int computeCommand = showConfirmDialog(null, options, "PRESENT FLOW RATE", OK_CANCEL_OPTION)
                showMessageDialog(null, "The supplied gas parameters previously obtained will be used to compute" +
                        "\nthe Flow Rate at Present Pressure Region")
                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def FRpresent = this.PresentFlowRate(gasPermPresent.text as Double, gasPermNormal.text as Double, thick.text as Double, avrPressurePresent.text as Double,
                                gasViscosity.text as Double, formVolFac.text as Double)
                        showMessageDialog(null, "Skin Factor for Normal Pressure Point Successful" +
                                "\n\n\nThe derived Skin Factor for Normal Flow Rate is: ${FRpresent}", "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        showMessageDialog(null, "Thanks for Using this Application, About to exit now", "EXIT", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break

            case 2://future GasPermFuture, perm, thick, avrPressureFuture, gasViscosity, formVolFac
                //Prompt the user to enter appropriate parameters:
                JTextField gasPermPresent = new JTextField("Permeability, K for Future Flow here")
                JTextField gasPermNormal = new JTextField("Universal Permeability, K here")
                JTextField thick = new JTextField("Thickness, H here")
                JTextField avrPressurePresent = new JTextField("Average Reservoir Present Real Gas Pressure")
                JTextField gasViscosity = new JTextField("Gas Viscosity here")
                JTextField formVolFac = new JTextField("Gas Formation Volume Factor ")

                Object[] options = [gasPermPresent, gasPermNormal, thick, avrPressurePresent, gasViscosity, formVolFac]
                 showMessageDialog(null, "INSTRUCTION: \nSupply all integer values as decimal i.e 2 as 2.0")

                int computeCommand = showConfirmDialog(null, options, "FUTURE FLOW RATE", OK_CANCEL_OPTION)
                 showMessageDialog(null, "The supplied gas parameters obtained previously will be used to compute" +
                         "\nthe Flow Rate at Future Pressure Region")
                if (computeCommand == OK_OPTION) {
                    //Begin the computation:
                    try {
                        def FRfuture = this.FutureFlowRate(gasPermPresent.text as Double, gasPermNormal.text as Double,
                                thick.text as Double, avrPressurePresent.text as Double, gasViscosity.text as Double, formVolFac.text as Double)
                        showMessageDialog(null, "Flow Rate for Future Pressure Point Successful" +
                                "\n\n\nThe derived Skin Factor for Normal Flow Rate is: ${FRfuture}", "COMPUTATION SUCCESSFUL", INFORMATION_MESSAGE)
                        showMessageDialog(null, "Thanks for Using this Application, About to exit now", "EXIT", INFORMATION_MESSAGE)
                        System.exit(0)
                    } catch (Exception ex) {
                        ex.printStackTrace()
                        showMessageDialog(null, "Error occurred in Computation!", "Flow Rate Computation Failure", WARNING_MESSAGE)
                        System.exit(0)
                    }
                } else {
                    showMessageDialog(null, "Application Cancelled...Goodbye")
                    System.exit(0)
                }
                break
        }
    }

}
