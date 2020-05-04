package channels;

import channelspojo.ChannelListResponse;
import channelspojo.ChannelListResponse.Channels;
import channelspojo.CreateChannelResponse;
import channelspojo.JoinChannelResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ApiConstants;
import utils.PropertyFileUtils;
import utils.RestManager;
import utils.RestRequest;
import java.util.HashMap;

import org.checkerframework.checker.units.qual.Length;

public class ChannelsActions {

	private String baseURI;
	private String token;
	PropertyFileUtils propertyFileUtils=new PropertyFileUtils();
	/**
	 * Constructor to initialize the value of BaseUri and Token
	 */
	public ChannelsActions()
	{
		this.baseURI=propertyFileUtils.getPropertyValue("config", "baseURI");
		this.token=propertyFileUtils.getPropertyValue("config", "token");
	}


	/**
	 * 	This method is used to build the request for channel creation
	 * @param channelName-name of the channel that needs to be created.
	 * @return
	 */
	public RestRequest buildCreateChannelRequest(String channelName)
	{
		HashMap<String,String> headers=new HashMap<String, String>();
		headers.put("Authorization", "Bearer " + token);
		String payload="{\"name\":" + "\"" + channelName + "\""+"}";
		return RestRequest.builder().method(RestRequest.METHOD.POST).url(baseURI+ApiConstants.CHANNEL_CREATE)
				.headers(headers).contentType(ContentType.JSON).payload(payload).build();

	}
	/**
	 * This method is used to post the request for channel creation
	 * @param name
	 * @return
	 */
	public CreateChannelResponse postCreateChannelRequest(String channelName) 
	{
		return RestManager.getInstance().execute(buildCreateChannelRequest(channelName)).as(CreateChannelResponse.class);
	}

	/**
	 * This method is used to build the request for channel rename
	 * @param existingChannelId-Id of channel whose name we want to change.
	 * @param newChannelName-new channel name
	 * @return
	 */
	public RestRequest buildRenameChannelRequest(String existingChannelId,String newChannelName)
	{
		HashMap<String,String> headers=new HashMap<String, String>();
		headers.put("Authorization", "Bearer " + token);
		String payload="{\"name\":" + "\"" + newChannelName + "\"" + ",\"channel\":" + "\"" + existingChannelId + "\"" + "}";
		return RestRequest.builder().method(RestRequest.METHOD.POST).url(baseURI+ApiConstants.CHANNEL_RENAME)
				.headers(headers).contentType(ContentType.JSON).payload(payload).build();
	}


	/**
	 * This method is used to post the request for channel rename
	* @param existingChannelId-Id of channel whose name we want to change.
	 *@param newChannelName-new channel name
	 * @return
	 */
	public CreateChannelResponse postRenameChannelRequest(String existingChannelId, String newChannelName)
	{
		return RestManager.getInstance().execute(buildRenameChannelRequest(existingChannelId,newChannelName)).as(CreateChannelResponse.class);
	}
	/**
	 *This method is used to build the request to list out the channels
	 * @return
	 */
	public RestRequest buildGetChannelsListRequest()
	{
		HashMap<String,String> headers=new HashMap<String, String>();
		headers.put("Authorization", "Bearer " + token);
		return RestRequest.builder().method(RestRequest.METHOD.GET).url(baseURI+ApiConstants.CHANNEL_LIST)
				.headers(headers).contentType(ContentType.JSON).build();
	}

	/**
	 * This method is used to get the  channel list
	 * @return
	 */

	public ChannelListResponse getChannelsListRequest() 
	{
		return RestManager.getInstance().execute(buildGetChannelsListRequest()).as(ChannelListResponse.class);
	}


	/**
	 * This method is used to build the request to archive the channel
	 * @param channelId
	 * @return
	 */
	public RestRequest buildArchiveChannelsRequest(String channelId)
	{
		HashMap<String,String> headers=new HashMap<String, String>();		
		headers.put("Authorization", "Bearer " + token);
		String payload="{\"channel\":" + "\"" + channelId + "\""+"}";
		return RestRequest.builder().method(RestRequest.METHOD.POST).url(baseURI+ApiConstants.CHANNEL_ARCHIVE)
				.headers(headers).contentType(ContentType.JSON).payload(payload).build();
	}


	/**
	 * This method is used to post the request to archive channels
	 * @param channelId
	 * @return
	 */
	public Response postArchiveChannelsRequest(String channelId)
	{
		return RestManager.getInstance().execute(buildArchiveChannelsRequest(channelId));
	}

	/**
	 * This method is used to build the request to join the channel
	 * @param channelName
	 * @return
	 */
	public RestRequest buildJoinChannelsRequest(String channelName)
	{
		HashMap<String,String> headers=new HashMap<String, String>();
		headers.put("Authorization", "Bearer " + token);
		String payload="{\"name\":" + "\"" + channelName + "\""+"}";
		return RestRequest.builder().method(RestRequest.METHOD.POST).url(baseURI+ApiConstants.CHANNEL_JOIN)
				.headers(headers).contentType(ContentType.JSON).payload(payload).build();
	}

	/**
	 * This method is used to post the request to join a channel
	 * @param channelName
	 * @return
	 */
	public JoinChannelResponse postJoinChannelsRequest(String channelName) 
	{
		return RestManager.getInstance().execute(buildJoinChannelsRequest(channelName)).as(JoinChannelResponse.class);
	}

	/**
	 * This method is used to get the id of channel based on its name.
	 * @param channelName
	 * @return- Channel id as String
	 */
	public String getChannelIdBasedOnChannelName(String channelName)
	{
		ChannelListResponse channelListResponse=getChannelsListRequest();
		ChannelListResponse.Channels channelList=channelListResponse.new Channels();
		String channelId="";
		System.out.println("passed channel name"+channelName);
		for(int i=0;i<channelListResponse.getChannels().length;i++)
		{
			channelList=channelListResponse.getChannels()[i];
			if(channelList.getName().contentEquals(channelName))
			{
				channelId=channelList.getId();
				break;
			}
		}
		return channelId;
	}

	/**
	 * This method is used to check whether the Channel name is present in the channel list of user or not
	 * @param channelName
	 * @return
	 */
	public boolean findPresenceOfChannel(String channelName)
	{
		boolean found=false;
		ChannelListResponse channelListResponse=getChannelsListRequest();
		ChannelListResponse.Channels channelList=channelListResponse.new Channels();
		String channelId="";
		System.out.println("passed channel name"+channelName);
		for(int i=0;i<channelListResponse.getChannels().length;i++)
		{
			channelList=channelListResponse.getChannels()[i];
			if(channelList.getName().contentEquals(channelName))
			{
				found=true;
				break;
			}
		}
		return found;
	}
	/**
	 * This method is used to check whether the Channel name is present in the channel list of user or not
	 * @param channelName
	 * @return
	 */
	public String isChannelArchived(String channelName)
	{
		String found="";
		ChannelListResponse channelListResponse=getChannelsListRequest();
		Channels channelObj=channelListResponse.new Channels();
		for(int i=0;i<channelListResponse.getChannels().length;i++)
		{
			channelObj=channelListResponse.getChannels()[i];
			if(channelObj.getName().contentEquals(channelName))
			{
				found =channelObj.getIs_archived();
				break;
			}
		}
		return found;
	}
	
	
	
	public static void main(String []args)
	{
		ChannelsActions channels=new ChannelsActions();
////		CreateChannelResponse createChannelResponse=channels.postCreateChannelRequest("automation_group2", "xoxp-1096622540018-1081890381575-1100001052162-2a220b4852866221cfe987576b9445d4");	
////		Assert.assertEquals(createChannelResponse.getOk().booleanValue(),true);
//		ChannelListResponse channelListResponse=channels.getChannelsListRequest("xoxp-1096622540018-1081890381575-1100001052162-2a220b4852866221cfe987576b9445d4");
//		Assert.assertEquals(channelListResponse.getOk().booleanValue(), true);
//		ChannelListResponse.Channel channelList=channelListResponse.new Channel();
//		int i=channelListResponse.getChannels().indexOf("testbyui");
//		String group_id=channelListResponse.getChannels().get(i).getId();
//		JoinChannelResponse joinChannelResponse=channels.postJoinChannelsRequest("testbyui", "xoxp-1096622540018-1081890381575-1100001052162-2a220b4852866221cfe987576b9445d4");	
//		Assert.assertEquals(joinChannelResponse.getOk().booleanValue(), true);
//		CreateChannelResponse createChannelResponse2=channels.postReanameChannelRequest(group_id,"3rd_group", "xoxp-1096622540018-1081890381575-1100001052162-2a220b4852866221cfe987576b9445d4");
//		Assert.assertEquals(createChannelResponse2.getOk().booleanValue(), true);
//		
//		for(i=0;i<channelListResponse.getChannels().size();i++)
//		{
//			channelList=channelListResponse.getChannels().get(i);
//			
//			if(channelList.getName().contentEquals("3rd_group"))
//			{
//				group_id=channelListResponse.getChannels().get(i).getId();
//				System.out.println("channel is renamed");
//				break;
//			}
//		}
//		Response response=channels.postArchiveChannelsRequest("group_id", "xoxp-1096622540018-1081890381575-1100001052162-2a220b4852866221cfe987576b9445d4");
//		Assert.assertEquals(response.getBody().jsonPath().getBoolean("ok"), true);
		
	}
	



}
