package exc

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class Exc1ControllerSpec extends Specification implements ControllerUnitTest<Exc1Controller> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
