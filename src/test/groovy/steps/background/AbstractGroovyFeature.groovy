package steps.background

import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractGroovyFeature {
    @Autowired protected GodAndOdinStep Given = new GodAndOdinStep();
    @Autowired protected GodAndOdinStep When = Given;
    @Autowired protected GodAndOdinStep Then = Given;
    @Autowired protected GodAndOdinStep And = Given;

    @Autowired protected GodAndOdinStep Gitt = Given;
    @Autowired protected GodAndOdinStep Naar = Given;
    @Autowired protected GodAndOdinStep Når = Given;
    @Autowired protected GodAndOdinStep Saa = Given;
    @Autowired protected GodAndOdinStep Så = Given;
    @Autowired protected GodAndOdinStep Og = Given;
}
