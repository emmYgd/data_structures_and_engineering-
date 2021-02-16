package PressureRegion;
import java.lang.Math
import static javax.swing.JOptionPane.*

public trait GasFlowRate {

    def logCalc (drainRad, wellBoreRad) {
        def logCalc = Math.log((drainRad/wellBoreRad) as Double)
        return logCalc
    }

    def commonDenumCalc(drainRad, wellBoreRad, skinFac){
        def partialDenum = this.logCalc(drainRad, wellBoreRad) - 0.75 + skinFac
        return partialDenum
    }

    //GasFlowRate for various Pressure Regions:
    def GFRgeneral(perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac){
        def EqnNum = perm * thick * (avrPseudo - avrWellFactor)
        def EqnDenum = 1422 * temp * (this.commonDenumCalc(drainRad, wellBoreRad, skinFac))

        def GFRgen = EqnNum / EqnDenum
        return GFRgen
    }

    def GFRgeneralAlt (genProdIndex, avrPseudo, avrWellFactor){
        def GFRgenAlt = genProdIndex * (avrPseudo * avrWellFactor)
        return GFRgenAlt
    }

    def GFRhigh(perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad, skinFac){
        def EqnNum = 7.08 * (1/Math.pow(10.0, 6.0)) * perm * thick * (avrPressure - avrPressureWellFactor)
        def EqnDenum = gasViscosity * formVolFac * (this.commonDenumCalc(drainRad, wellBoreRad, skinFac))

        def GFRhigh = EqnNum/EqnDenum
        return GFRhigh
    }

    def GFRhighAlt = {
        return null;
    }

    def GFRlow(perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac){
        def EqnNum = perm * thick * ((Math.pow(avrPressure, 2.0)) - (Math.pow(avrPressureWellFactor, 2.0)))
        def EqnDenum = 1422 * temp * (gasViscosity * gasCompressFac) * (this.commonDenumCalc(drainRad, wellBoreRad, skinFac))

        def GFRlow = EqnNum/EqnDenum
        return GFRlow
    }

    def GFRlowAlt (lowProIndex, avrPressure, avrPressureWellFactor){
        def GFRlowAlt = lowProIndex * ((Math.pow((double)avrPressure, 2.0)) - (Math.pow((double)avrPressureWellFactor, 2.0)))
        return GFRlowAlt
    }

}