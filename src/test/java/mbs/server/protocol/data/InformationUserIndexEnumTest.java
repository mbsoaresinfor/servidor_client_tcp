package mbs.server.protocol.data;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class InformationUserIndexEnumTest {
	

		@Test
		public void testValuesIndex() {
			Assert.assertEquals(0, InformationUserIndexEnum.Idade.getValue());
			Assert.assertEquals(2, InformationUserIndexEnum.Altura.getValue());
			Assert.assertEquals(4, InformationUserIndexEnum.Nome.getValue());
			Assert.assertEquals(1, InformationUserIndexEnum.Peso.getValue());
			Assert.assertEquals(3, InformationUserIndexEnum.TamanhoNome.getValue());
			
		}


}
