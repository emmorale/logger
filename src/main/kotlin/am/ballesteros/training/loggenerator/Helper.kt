package am.ballesteros.training.loggenerator

import java.util.*

class Helper {
    companion object {
        fun ClosedRange<Int>.random() =
                Random().nextInt((endInclusive + 1) - start) +  start

        fun List<*>.random()
                = if (this.isEmpty()) null else this[Random().nextInt(this.size)]

        fun getRandomIp(): String {
            return "" + (0..255).random() + "." + (0..255).random() + "." + (0..255).random() + "." + (0..255).random()
        }

        fun getRandomStatus( number: Boolean = true): Any {
            if (number)
                return listOf(200, 202, 204, 100, 201, 150, 250, 400, 404, 500).random() as Int
            else
                return listOf("SUCCESS", "FAILURE").random() as String
        }

        fun getRandomUsername(): String {
            return listOf("Conan", "SuperLopez", "Mortadelo", "Filemon", "Superman", "Batman", "Robin", "Flash",
                    "Zipi", "Zape", "Sacarino", "Carpanta", "Bacterio", "Rompetechos", "Pantuflo", "Thor", "IronMan",
                    "IronFish").random() as String
        }

        fun getRandomTime(): Float {

            return (1..8000).random().div(1000.toFloat())
        }

        fun getRandomAction(): String {
            return listOf("LOGIN", "EXPORT DATA", "DOWNLOAD DOCUMENT", "SEND EMAIL", "CREATE USER", "DELETE USER")
                    .random() as String
        }

        fun getRandomMessage(): String {
            return listOf(
                    "Error creating user",
                    "Lazy Loading is not allowed in this context",
                    "User can not be null. Can not fetch information from the database",
                    "Error connecting to database",
                    "Current user is not able to perform this action",
                    "Document not found",
                    "User not found",
                    "Email error: can not connect to SMTP Server",
                    "Invalid credentials. User will be flag as inactive",
                    "Number expected",
                    "Form can not be validated due to some database issue"
            ).random() as String
        }
    }
}

