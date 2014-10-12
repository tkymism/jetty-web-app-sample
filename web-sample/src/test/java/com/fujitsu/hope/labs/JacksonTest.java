package com.fujitsu.hope.labs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.OutputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.fujitsu.hope.labs.model.Message;

public class JacksonTest {
	@Test
	public void testMessageModelEncode() throws JsonGenerationException, JsonMappingException, IOException{
		Message m = new Message();
		m.setId(101L);
		m.setText("hoge");
		ObjectMapper mapper = new ObjectMapper();
		StringOutputStream os = new StringOutputStream();
		mapper.writeValue(os, m);
		assertThat(os.toString(), is("{\"id\":101,\"text\":\"hoge\"}"));
	}
	class StringOutputStream extends OutputStream{
		StringBuffer sb = new StringBuffer();
		@Override
		public void write(int b) throws IOException {
			sb.append((char) b);
		}
		public String toString(){
			return sb.toString();
		}
	}
}
