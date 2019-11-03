package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.handlersTestSuite;
import org.wahlzeit.model.modelTestSuite;
import org.wahlzeit.services.EmailServiceTestSuite;
import org.wahlzeit.utils.utilsTestSuite;


@RunWith(Suite.class)
@SuiteClasses({
        utilsTestSuite.class,
        EmailServiceTestSuite.class,
        modelTestSuite.class,
        handlersTestSuite.class})
public class AllTests {


}
