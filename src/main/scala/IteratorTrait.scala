trait IteratorTrait[T] {
  def hasNext: Boolean
  def next(): T
}

class Iterator(length: Int) extends IteratorTrait[Int] {
  private var current = 0
  override def hasNext: Boolean = current < length
  override def next(): Int = {
    if(hasNext) {
      val t = current
      current += 1
      t
    } else {
      0
    }
  }
}