import info.devpages.chapter4.{Option, Some}

val s = "Some String"
val list: List[Option[String]] = List(Some(s))
val list2: List[None.type] = List(None)
val l: Option[String] = list.head.map(x => x)
val l2 = list.head.flatMap(x => Some(x.toLowerCase()))

