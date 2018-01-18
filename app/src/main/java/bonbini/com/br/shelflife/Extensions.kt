package bonbini.com.br.shelflife

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro(): String {
	val formatoBrasileiro = "dd-MM-yyyy"
	val format = SimpleDateFormat(formatoBrasileiro, Locale("pt", "br"))
	return format.format(this.time)
}