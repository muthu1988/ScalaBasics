object IdGenerator {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}
