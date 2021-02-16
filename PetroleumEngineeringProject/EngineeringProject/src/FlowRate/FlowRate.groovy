package FlowRate

trait FlowRate {
    def NormalFlowRate(gasPerm, thick, avrPressure, avrPressureWellFactor, gasViscosity,
                       formVolFac, drainRad, wellBoreRad, scaleFactor){
        def EqnNum = gasPerm * thick * (avrPressure - avrPressureWellFactor)
        def EqnDenum = 141.2 * (gasViscosity * formVolFac) * (Math.log((drainRad/wellBoreRad) as Double) + scaleFactor)

        def NormalFlowRate = EqnNum/EqnDenum
        return NormalFlowRate
    }

    def PresentFlowRate(GasPermPresent, perm, thick, avrPressurePresent, gasViscosity, formVolFac){
        def firstComp = (perm * thick)/141.2
        def secondComp = GasPermPresent/(gasViscosity * formVolFac)

        def PresentFlowRate = firstComp * secondComp * avrPressurePresent
        return PresentFlowRate
    }

    def PresentOut = {GasPermPresent, perm, thick, avrPressurePresent, gasViscosity, formVolFac ->
        return PresentFlowRate()
    }.memoize()

    def FutureFlowRate(GasPermFuture, perm, thick, avrPressureFuture, gasViscosity, formVolFac){
        def FutureFlowRate = this.PresentOut(GasPermFuture, perm, thick, avrPressureFuture, gasViscosity, formVolFac)
        return FutureFlowRate
    }
}