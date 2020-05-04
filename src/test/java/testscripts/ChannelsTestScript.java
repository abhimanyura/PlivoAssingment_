package testscripts;

import channels.ChannelsActions;
import channelspojo.CreateChannelResponse;
import channelspojo.JoinChannelResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyFileUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChannelsTestScript {

//Object Creation	
ChannelsActions channels=new ChannelsActions();
PropertyFileUtils propertyFileUtils=new PropertyFileUtils();
CreateChannelResponse createChannelResponse=new CreateChannelResponse();
private  String channelName;
private  String newChannelName;

//Variable to store property key value pair in MAP.
Map<String ,String> propertyMap=new HashMap<>();
String channelId;


/*
 * Constructor
 */
public ChannelsTestScript() {
	propertyMap=propertyFileUtils.getPropertyKeyValuePair("config");
	Random random=new Random();
	random.nextInt(200);
	channelName=propertyMap.get("channelName")+random.nextInt(200);
	newChannelName=propertyMap.get("newchannelName")+random.nextInt(200);
}


@Test(priority=1,description="Create a slack Channel")
public void createChannel()
{
	createChannelResponse=channels.postCreateChannelRequest(channelName);
	Assert.assertEquals(createChannelResponse.getOk().booleanValue(),true,"Channel is created");
}


@Test(priority=2,description = "Join the newly created channel")
public void joinChannel()
{
	JoinChannelResponse joinChannelResponse=channels.postJoinChannelsRequest(channelName);
	Assert.assertEquals(joinChannelResponse.getOk().booleanValue(), true,"User joined the channel");
}

@Test(priority=3,description = "Rename the channel" )
public void renameChannel()
{
	 channelId=channels.getChannelIdBasedOnChannelName(channelName);
	createChannelResponse=channels.postRenameChannelRequest(channelId,newChannelName);
	Assert.assertEquals(createChannelResponse.getOk().booleanValue(), true,"Channel is renamed");
}

@Test(priority=4,description = "Validate The renaming Of Channel",dependsOnMethods ="renameChannel")
public void validateRenameOfaChannel()
{
	
	Assert.assertEquals(channels.findPresenceOfChannel(newChannelName), true,"Channel is Renamed");
}

@Test(priority = 5,description = "Archive the channel")
public void archiveChannel()
{
	channelId=channels.getChannelIdBasedOnChannelName(newChannelName);
	Response response=channels.postArchiveChannelsRequest(channelId);
	Assert.assertEquals(response.getBody().jsonPath().getBoolean("ok"), true,"Channel is archievd");
}
@Test(priority=6,description = "Verify the channel is archived from channel list")
public void verifyArchiveChannel()
{	
	Assert.assertEquals(channels.isChannelArchived(newChannelName), "true","Channel is Archived");
}
}
