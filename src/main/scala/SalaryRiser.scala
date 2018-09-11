object SalaryRiser {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double) : List[Double] = salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]) : List[Double] = promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]) : List[Double] = promotion(salaries, salary => salary * Math.log(salary))

  def hugePromotion(salaries: List[Double]) : List[Double] = promotion(salaries, salary => salary * salary)

}
