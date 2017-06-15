package org.eop.amab.test

import org.eop.amab.AmabContext
import org.eop.amab.AmabManager
import org.eop.amab.AmabResult
import org.eop.amab.AmabSetting
import org.eop.amab.CompiledCode
import org.eop.amab.SourceCode
import org.eop.chassis.test.AbstractCommonTest
import org.eop.jmx.builder.MapBuilder
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-05-06
 */
class AmabManagerTest extends AbstractCommonTest {

	@Test
	void test1() {
		def source = '''\
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
		AmabSetting setting = new AmabSetting()
		setting.addSetting('output.format', 'true')
		CompiledCode compiledCode = AmabManager.compile(new SourceCode(source), setting)
		AmabContext context = new AmabContext()
		MapBuilder mb = new MapBuilder()
		mb.keymap('person').keyval('name', '李新杰')
						   .keyval('age', 32)
						   .keyvals('phones', '13676969793', '13676969795')
						   .keyval('address', '河南郑州')
						   .end()
		context.addVar('input', mb.toMap())
		AmabResult result = AmabManager.execute(compiledCode, setting, context)
		println result.getOutput()
	}
	
	@Test
	void test2() {
		def source = '''\
#{foreach(person in input:persons[])}
	${person:name<>}
	${person:age<>}
	${person:phones<>}
	${person:address<>}
#{end}
'''
		AmabSetting setting = new AmabSetting()
		setting.addSetting('output.format', 'true')
		CompiledCode compiledCode = AmabManager.compile(new SourceCode(source), setting)
		AmabContext context = new AmabContext()
		MapBuilder mb = new MapBuilder()
		mb.keylist('persons').itemmap().keyval('name', '李新杰1')
									   .keyval('age', 32)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州1')
									   .end()
						     .itemmap().keyval('name', '李新杰2')
									   .keyval('age', 33)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州2')
									   .end()
		context.addVar('input', mb.toMap())
		AmabResult result = AmabManager.execute(compiledCode, setting, context)
		println result.getOutput()
	}
	
	@Test
	void test3() {
		def source = '''\
#{foreach(person in input:persons[])}
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	#{foreach(entry in person)}
		${entry:key<>}=${entry:value<>}
	#{end}
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
#{end}
'''
		AmabSetting setting = new AmabSetting()
		setting.addSetting('output.format', 'true')
		CompiledCode compiledCode = AmabManager.compile(new SourceCode(source), setting)
		AmabContext context = new AmabContext()
		MapBuilder mb = new MapBuilder()
		mb.keylist('persons').itemmap().keyval('name', '李新杰1')
									   .keyval('age', 32)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州1')
									   .end()
							 .itemmap().keyval('name', '李新杰2')
									   .keyval('age', 33)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州2')
									   .end()
		context.addVar('input', mb.toMap())
		AmabResult result = AmabManager.execute(compiledCode, setting, context)
		println result.getOutput()
	}
	
	@Test
	void test4() {
		def source = '''\
#{if(input:persons[].#0{}.name1<>)}
${input:persons[].#0{}.name<>}
#{elif(input:persons[].#0{}.age1<>)}
${input:persons[].#0{}.age<>}
#{elif(input:persons[].#0{}.phones1<>)}
${input:persons[].#0{}.phones<>}
#{else}
${input:persons[].#0{}.address<>}
#{end}
'''
		AmabSetting setting = new AmabSetting()
		setting.addSetting('output.format', 'true')
		CompiledCode compiledCode = AmabManager.compile(new SourceCode(source), setting)
		AmabContext context = new AmabContext()
		MapBuilder mb = new MapBuilder()
		mb.keylist('persons').itemmap().keyval('name', '李新杰1')
									   .keyval('age', 32)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州1')
									   .end()
							 .itemmap().keyval('name', '李新杰2')
									   .keyval('age', 33)
									   .keyvals('phones', '13676969793', '13676969795')
									   .keyval('address', '河南郑州2')
									   .end()
		context.addVar('input', mb.toMap())
		AmabResult result = AmabManager.execute(compiledCode, setting, context)
		println result.getOutput()
	}
}
