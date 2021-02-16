package PressureRegion;

trait ProductivityIndex extends GasFlowRate {

    def PIgeneral (perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad, skinFac){
        def EqnNum = perm * thick
        def EqnDenum = 1422 * temp * (commonDenumCalc(drainRad, wellBoreRad, skinFac))

        def prodIndex = EqnNum/EqnDenum
        return prodIndex
    }

    def PIgenAlt (GFRgeneral, avrPseudo, avrWellFactor){
        def PIgenAlt = GFRgeneral/(avrPseudo - avrWellFactor)
        return PIgenAlt
    }

    def PIhigh(){
        return null
    }

    def PIhighAlt = {
        return null
    }

    def PIlow(perm, thick, temp, avrPressure, avrPressureWellFactor, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac){
        def EqnNum = perm * thick
        def EqnDenum = 1422 * temp * (gasViscosity * gasCompressFac) * (commonDenumCalc(drainRad, wellBoreRad, skinFac))

        def prodIndex = EqnNum/EqnDenum
        return prodIndex
    }

    def PIlowAlt (GFRlow, avrPressure, avrPressureWellFactor){
        def PIlowAlt = GFRlow/(avrPressure - avrPressureWellFactor)
        return PIlowAlt
    }
}
