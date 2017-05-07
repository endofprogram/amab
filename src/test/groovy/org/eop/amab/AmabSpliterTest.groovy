package org.eop.amab

import org.eop.chassis.test.AbstractCommonTest
import org.junit.Test

/**
 * @author lixinjie
 * @since 2017-05-06
 */
class AmabSpliterTest extends AbstractCommonTest {

	@Test
	void test1() {
		SplitedCode splitedCode = AmabSpliter.split(new SourceCode(getSource()))
		splitedCode.getSections().each{
			println it
		}
	}
	
	String getSource() {
		'''\
#{import java.util.Date}
#{import java.util.Date}
<?xml version="1.0" encoding="UTF-8"?>
<Request>
	<Name>${input://person{}/name<>}</Name>
	<Age>${input://person{}/age<>}</Age>
	<Phones>
	#{delimiter=","}#{begin="{"}#{end="}"}
	#{time=new Date()}#{age=input://person{}/age<Integer>}
	#{foreach(phone in input://person{}/phones[])}
		${index}<Phone>${phone}</Phone>
		${datetime://now}
	#{end}
	</Phones>
	<Address>${input://person{}/address<>}</Address>
	<CreateTime>${datetime://now}</CreateTime>
	<RandomKey>${random://num8}</RandomKey>
	##。。。。。。。
	#*。。。。。。*#
</Request>
'''
	}
}
