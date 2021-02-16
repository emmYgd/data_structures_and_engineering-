package PressureRegion

trait SkinFactor {

    def SkinFactorUniversal(perm, permDueToSkin, damageRad, wellBoreRad){
        def SFgenAlt = ((perm/permDueToSkin) - 1) * Math.log((damageRad/wellBoreRad) as Double)

            if (SFgenAlt == 0) {
                return ["SFgenValue": SFgenAlt, "SFgenState": "NORMAL STATE"]
            } else if(SFgenAlt < 0){
                return ["SFgenValue": SFgenAlt, "SFgenState": "STIMULATION STATE"]
            }else if(SFgenAlt > 0){
                return ["SFgenValue": SFgenAlt, "SFgenState": "DAMAGED STATE"]
            }

    }

    //SkinFactor to be obtained from  Flow predictions:
    def SkinFactorFromFlowPrediction(NormalFlowRate, gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad){
        def CalcFirstPartNum = gasPerm * thick * (avrPressure - avrPressureWellFactor)
        def CalcFirstPartDenum = 141.2 * (gasViscosity * formVolFac) * NormalFlowRate

        def SkinFactor = (CalcFirstPartNum/CalcFirstPartDenum) - Math.log((drainRad/wellBoreRad) as Double)
        //return SkinFactor
        if (SkinFactor == 0) {
            return ["SFgenValue": SkinFactor, "SFgenState": "NORMAL STATE"]
        } else if(SFgen < 0){
            return ["SFgenValue": SkinFactor, "SFgenState": "STIMULATION STATE"]
        }else if(SFgen > 0){
            return ["SFgenValue": SkinFactor, "SFgenState": "DAMAGED STATE"]
        }
    }

    def SkinFactorGeneral (GFRgeneral, perm, thick, avrPseudo, avrWellFactor, temp, drainRad, wellBoreRad){
        def firstPartCalc = (perm * thick * (avrPseudo * avrWellFactor))/(1422 * temp * GFRgeneral)
        def secondPartCalc = 0.75 - Math.log((drainRad/wellBoreRad) as Double)

        def SFgen = firstPartCalc + secondPartCalc
        //return {
            if (SFgen == 0) {
                return ["SFgenValue": SFgen, "SFgenState": "NORMAL STATE"]
            } else if(SFgen < 0){
                return ["SFgenValue": SFgen, "SFgenState": "STIMULATION STATE"]
            }else if(SFgen > 0){
                return ["SFgenValue": SFgen, "SFgenState": "DAMAGED STATE"]
            }
        //}
    }

    def SkinFactorHigh (GFRhigh, perm, thick, avrPressure, avrPressureWellFactor, gasViscosity, formVolFac, drainRad, wellBoreRad){
        def FirstPartUpper =  7.08 * (1/(Math.pow(10.0, 6.0))) * perm * thick * (avrPressure - avrPressureWellFactor)
        def FirstPartLower = GFRhigh * gasViscosity * formVolFac
        def SecondPartCalc = 0.75 - Math.log((drainRad/wellBoreRad) as Double)

        def SkinFactor = (FirstPartUpper/FirstPartLower) + SecondPartCalc
        //return {
            if (SkinFactor == 0) {
                return ["SFgenValue": SkinFactor, "SFgenState": "NORMAL STATE"]
            } else if(SkinFactor < 0){
                return ["SFgenValue": SkinFactor, "SFgenState": "STIMULATION STATE"]
            }else if(SkinFactor > 0){
                return ["SFgenValue": SkinFactor, "SFgenState": "DAMAGED STATE"]
            }
        //}
    }

    def SkinFactorLow(GFRlow, perm, thick, avrPressure, avrPressureWellFactor, temp, gasViscosity, gasCompressFac, drainRad, wellBoreRad, skinFac){
        def FirstPartUpper = perm * thick * ((Math.pow((Double)avrPressure, 2.0)) - (Math.pow((Double)avrPressureWellFactor, 2.0)))
        def FirstPartLower = 1422 * temp * (gasViscosity * gasCompressFac) * GFRlow
        def SecondPartCalc = 0.75 - Math.log((drainRad/wellBoreRad) as Double)

        def SkinFactor = (FirstPartUpper/FirstPartLower) + SecondPartCalc
        //return {
            if (SkinFactor == 0) {
                return ["SFgenValue": SkinFactor, "SFgenState": "NORMAL STATE"]
            } else if(SkinFactor < 0){
                return ["SFgenValue": SkinFactor, "SFgenState": "STIMULATION STATE"]
            }else if(SkinFactor > 0){
                return ["SFgenValue": SkinFactor, "SFgenState": "DAMAGED STATE"]
            }
        //}
    }

}
