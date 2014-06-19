/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author kenshin
 */
package org.foxbpm.kernel.test;

import org.foxbpm.kernel.ProcessDefinitionBuilder;
import org.foxbpm.kernel.process.KernelProcessDefinition;
import org.foxbpm.kernel.runtime.KernelProcessInstance;
import org.foxbpm.kernel.test.behavior.AutomaticBehavior;
import org.foxbpm.kernel.test.behavior.TestEndBehavior;


/**
 * 内核基础测试
 * @author kenshin
 *
 */
public class KernelTest extends KernelTestCase {
	
	public void testProcessDefinitionBuilder(){
		
		KernelProcessDefinition processDefinition=new ProcessDefinitionBuilder("kernelTest")
		.createFlowNode("start")
        .initial()
        .behavior(new AutomaticBehavior())
        .sequenceFlow("task")
        .endFlowNode()
        .createFlowNode("task")
        .behavior(new AutomaticBehavior())
        .sequenceFlow("end")
        .endFlowNode()
        .createFlowNode("end")
        .behavior(new TestEndBehavior())
        .endFlowNode()
		.buildProcessDefinition();

		KernelProcessInstance processInstance=processDefinition.createProcessInstance();
		processInstance.start();
		
		
		
		assertTrue(processInstance.getRootToken().isEnded());
		assertTrue(processInstance.isEnded());
		
		
	}

}
