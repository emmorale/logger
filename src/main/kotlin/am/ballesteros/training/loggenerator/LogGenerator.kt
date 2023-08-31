package am.ballesteros.training.loggenerator

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import org.slf4j.LoggerFactory


class LogGenerator

fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)

private val LOG = loggerFor(LogGenerator::class.java)

fun main(args: Array<String>) = mainBody {

    ArgParser(args).parseInto(::CliArgs).run {
        generateTraces(iterations, delay)
    }
}

fun generateTraces(iterations: Int, delay: Long) {
    var n = 0;

    while (n++ < iterations || iterations == -1) {

        if (n % 5 == 0) LOG.info(generateLoginTrace())
        if (n % 2 == 0) LOG.info(generatePerformanceTrace())

        if (n % 20 == 0) {
            try {
                generateExceptionTrace()
            } catch (e: Exception) {
                LOG.error(e.message + "|", e)
            }
        }

        Thread.sleep(delay);
    }
}

fun generateLoginTrace (): String {
    LOG.debug("Creating Login Trace")

    val ip = Helper.getRandomIp()
    val status = Helper.getRandomStatus()
    val username = Helper.getRandomUsername()

    return "LOGIN|$status|$username|$ip"
}

fun generatePerformanceTrace(): String {
    LOG.debug("Creating Performance Trace")

    val time = Helper.getRandomTime()
    val action = Helper.getRandomAction()
    val username = Helper.getRandomUsername()
    val status = Helper.getRandomStatus(false)

    return "PERFORMANCE|$time|$action|$status|$username"
}

fun generateExceptionTrace(): Nothing {
    LOG.debug("Creating Error Trace")

    val message = Helper.getRandomMessage();
    throw Exception(message)
}



