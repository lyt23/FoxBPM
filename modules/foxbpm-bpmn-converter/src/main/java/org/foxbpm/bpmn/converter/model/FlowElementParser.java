package org.foxbpm.bpmn.converter.model;

import org.eclipse.bpmn2.BaseElement;
import org.foxbpm.engine.impl.behavior.BaseElementBehavior;
import org.foxbpm.engine.impl.behavior.FlowElementBehavior;

public abstract class FlowElementParser extends BaseElementParser {

	@Override
	public BaseElementBehavior parser(BaseElement baseElement) {
		return super.parser(baseElement);
	}

	public void init() {
		super.init();
	}
	
	

}