package exc

import grails.converters.JSON

/**
 * time out 示範程式
 */
class Exc1Controller {

    def timeOutService

    JSON exc1() {

        HashMap returnVal = timeOutService.httpTimeOutBad1()

        render returnVal as JSON
    }

    JSON exc2() {

        LinkedHashMap returnVal = timeOutService.httpTimeOutBad2()

        render returnVal as JSON
    }

    JSON exc3() {

        LinkedHashMap returnVal = timeOutService.httpTimeOut()

        render returnVal as JSON
    }
}
