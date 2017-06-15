package org.eop.amab.test

import org.eop.amab.AmabCompiler
import org.eop.amab.AmabContext
import org.eop.amab.AmabExecutor
import org.eop.amab.AmabResult
import org.eop.amab.AmabSetting
import org.eop.amab.AmabSpliter
import org.eop.amab.CompiledCode
import org.eop.amab.SourceCode
import org.eop.amab.SplitedCode
import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.MapBuilder
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-05-06
 */
class AmabExecutorTest extends AbstractCommonTest {

	@Test
	void test1() {
		SplitedCode splitedCode = AmabSpliter.split(new SourceCode(getSource()))
		AmabSetting setting = new AmabSetting()
		setting.addSetting('output.format', 'true')
		CompiledCode compiledCode = AmabCompiler.compile(splitedCode, setting)
		AmabContext context = new AmabContext()
		MapBuilder mb = new MapBuilder()
		mb.keymap('person').keyval('name', '李新杰')
						   .keyval('age', 32)
						   .keyvals('phones', '13676969793', '13676969795')
						   .keyval('address', '河南郑州')
						   .end()
		context.addVar('input', mb.toMap())
		AmabResult result = AmabExecutor.execute(compiledCode, setting, context)
		println result.getOutput()
	}
	
	String getSource() {
		'''\
<?xml version="1.0" encoding="UTF-8"?>
<Request>
	<Name>${input:person{}.name<>}</Name>
	<Age>${input:person{}.age<>}</Age>
	<Sex>#{if(input:person{}.sex<>)}${input:person{}.sex<>}#{else}你猜#{end}</Sex>
	<Phones>
	#{foreach(phone in input:person{}.phones[])}
		<Phone>${phone}</Phone>
	#{end}
	</Phones>
	<Address>${input:person{}.address<>}</Address>
	##。。。。。。。
	#*。。。。。。*#
</Request>
'''
	}
}
