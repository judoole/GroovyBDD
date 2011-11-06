package steps.background

import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractGroovyFeature {
    @Autowired protected GodAndOdinStep Given = new GodAndOdinStep();
    @Autowired protected GodAndOdinStep When = Given;
    @Autowired protected GodAndOdinStep Then = Given;
    @Autowired protected GodAndOdinStep And = Given;
}
