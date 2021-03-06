package kbasesearchengine.events.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kbasesearchengine.events.AccessGroupStatus;
import kbasesearchengine.events.ObjectStatusEvent;
import kbasesearchengine.events.storage.ObjectStatusCursor;
import kbasesearchengine.events.storage.StatusEventStorage;

public class FakeStatusStorage implements StatusEventStorage {

	@Override
	public int count(String storageCode, boolean processed) throws IOException {
		return 0;
	}

	@Override
	public List<ObjectStatusEvent> find(String storageCode, boolean processed,
			int maxSize) throws IOException {
		return new ArrayList<ObjectStatusEvent>();
	}

	@Override
	public void createStorage() throws IOException {
	}

	@Override
	public void deleteStorage() throws IOException {
	}

	@Override
	public void markAsNonprocessed(String storageCode, String storageObjectType)
			throws IOException {		
	}

	@Override
	public void markAsProcessed(ObjectStatusEvent row, boolean isIndexed)
			throws IOException {
	}

	@Override
	public void store(ObjectStatusEvent obj) throws IOException {
	}

	@Override
	public ObjectStatusCursor cursor(String storageCode, boolean processed, int pageSize, String timeAlive)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ObjectStatusEvent> find(String storageCode, int accessGroupId, List<String> accessGroupObjectIds)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccessGroupStatus> findAccessGroups(String storageCode) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nextPage(ObjectStatusCursor cursor, int nRemovedItems) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}
