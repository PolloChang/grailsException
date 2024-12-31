package exc

import ex.HttpTimeOutExample
import grails.gorm.transactions.Transactional

/**
 * time out 示範程式
 */
@Transactional
class TimeOutService {

    /**
     * 不好示範1: 直接丟 Exception
     */
    HashMap httpTimeOutBad1() {

        HashMap returnVal = [:]

        try {
            HttpTimeOutExample example = new HttpTimeOutExample()
            returnVal = example.clineTimeout()
        } catch (Exception e) {
            e.printStackTrace()
        }

        return returnVal
    }


    /**
     * 不好示範2: 直接丟 Exception
     */
    LinkedHashMap httpTimeOutBad2() {

        LinkedHashMap returnVal = [:]

        try {
            HttpTimeOutExample example = new HttpTimeOutExample()
            returnVal = example.clineTimeout2()
        } catch (Exception e) {
            e.printStackTrace()
            log.error(e.message)
        }

        return returnVal
    }

    /**
     * 最佳示範
     */
    LinkedHashMap httpTimeOut() {

        LinkedHashMap returnVal = [:]

        try {
            HttpTimeOutExample example = new HttpTimeOutExample()
            returnVal = example.clineTimeout2()
        } catch (Exception e) {
            log.error("未知錯誤",e)
        }

        return returnVal
    }
}
