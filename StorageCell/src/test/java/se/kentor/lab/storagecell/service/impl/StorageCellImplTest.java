/**
 * 
 */
package se.kentor.lab.storagecell.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.kentor.lab.storagecell.service.IStorageCellService;

/**
 * @author muqkha
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/cell-storage-service.xml")

public class StorageCellImplTest {
	
	@Autowired
	private IStorageCellService iStorageCell;
	
	@Test
	public void testPrepareStorageCell() {
		iStorageCell.prepareCellStorage();
		Assert.assertNotNull(iStorageCell.getAllCells());
		Assert.assertNotNull(iStorageCell.getAvailableCells());
		Assert.assertNotNull(iStorageCell.getOccupiedCells());
	}

}
