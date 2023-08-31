package am.ballesteros.training.loggenerator

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

/**
 * Args Parser
 */
class CliArgs (parser: ArgParser) {
    val iterations by parser.storing(
            "-l", "--loop",
            help = "Number of iterations. Keep in mind that 5 traces can be generated randomly in each iteration. " +
                    "Use -1 for an unlimited number of iterations. Default value: 1000") { toInt() }
            .default(1000)

    val delay by parser.storing(
            "-d", "--delay",
            help = "Delay after each iteration (in milliseconds). Default values: 1000") { toLong() }
            .default(1000)
}