package channelspojo;

public class ChannelListResponse
{
    private Channels[] channels;

    private String ok;

    public Channels[] getChannels ()
    {
        return channels;
    }

    public void setChannels (Channels[] channels)
    {
        this.channels = channels;
    }

    public String getOk ()
    {
        return ok;
    }

    public void setOk (String ok)
    {
        this.ok = ok;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channels = "+channels+", ok = "+ok+"]";
    }
public class Topic
{
    private String last_set;

    private String creator;

    private String value;

    public String getLast_set ()
    {
        return last_set;
    }

    public void setLast_set (String last_set)
    {
        this.last_set = last_set;
    }

    public String getCreator ()
    {
        return creator;
    }

    public void setCreator (String creator)
    {
        this.creator = creator;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [last_set = "+last_set+", creator = "+creator+", value = "+value+"]";
    }
}
public class Channels
{
    private String is_private;

    private String creator;

    private String is_member;

    private String is_mpim;

    private Purpose purpose;

    private String created;

    private String name_normalized;

    private String unlinked;

    private String is_archived;

    private String is_channel;

    private String is_general;

    private String is_shared;

    private String[] members;

    private String num_members;

    private String name;

    private Topic topic;

    private String id;

    private String[] previous_names;

    private String is_org_shared;

    public String getIs_private ()
    {
        return is_private;
    }

    public void setIs_private (String is_private)
    {
        this.is_private = is_private;
    }

    public String getCreator ()
    {
        return creator;
    }

    public void setCreator (String creator)
    {
        this.creator = creator;
    }

    public String getIs_member ()
    {
        return is_member;
    }

    public void setIs_member (String is_member)
    {
        this.is_member = is_member;
    }

    public String getIs_mpim ()
    {
        return is_mpim;
    }

    public void setIs_mpim (String is_mpim)
    {
        this.is_mpim = is_mpim;
    }

    public Purpose getPurpose ()
    {
        return purpose;
    }

    public void setPurpose (Purpose purpose)
    {
        this.purpose = purpose;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getName_normalized ()
    {
        return name_normalized;
    }

    public void setName_normalized (String name_normalized)
    {
        this.name_normalized = name_normalized;
    }

    public String getUnlinked ()
    {
        return unlinked;
    }

    public void setUnlinked (String unlinked)
    {
        this.unlinked = unlinked;
    }

    public String getIs_archived ()
    {
        return is_archived;
    }

    public void setIs_archived (String is_archived)
    {
        this.is_archived = is_archived;
    }

    public String getIs_channel ()
    {
        return is_channel;
    }

    public void setIs_channel (String is_channel)
    {
        this.is_channel = is_channel;
    }

    public String getIs_general ()
    {
        return is_general;
    }

    public void setIs_general (String is_general)
    {
        this.is_general = is_general;
    }

    public String getIs_shared ()
    {
        return is_shared;
    }

    public void setIs_shared (String is_shared)
    {
        this.is_shared = is_shared;
    }

    public String[] getMembers ()
    {
        return members;
    }

    public void setMembers (String[] members)
    {
        this.members = members;
    }

    public String getNum_members ()
    {
        return num_members;
    }

    public void setNum_members (String num_members)
    {
        this.num_members = num_members;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Topic getTopic ()
    {
        return topic;
    }

    public void setTopic (Topic topic)
    {
        this.topic = topic;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getPrevious_names ()
    {
        return previous_names;
    }

    public void setPrevious_names (String[] previous_names)
    {
        this.previous_names = previous_names;
    }

    public String getIs_org_shared ()
    {
        return is_org_shared;
    }

    public void setIs_org_shared (String is_org_shared)
    {
        this.is_org_shared = is_org_shared;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [is_private = "+is_private+", creator = "+creator+", is_member = "+is_member+", is_mpim = "+is_mpim+", purpose = "+purpose+", created = "+created+", name_normalized = "+name_normalized+", unlinked = "+unlinked+", is_archived = "+is_archived+", is_channel = "+is_channel+", is_general = "+is_general+", is_shared = "+is_shared+", members = "+members+", num_members = "+num_members+", name = "+name+", topic = "+topic+", id = "+id+", previous_names = "+previous_names+", is_org_shared = "+is_org_shared+"]";
    }
}
public class Purpose
{
    private String last_set;

    private String creator;

    private String value;

    public String getLast_set ()
    {
        return last_set;
    }

    public void setLast_set (String last_set)
    {
        this.last_set = last_set;
    }

    public String getCreator ()
    {
        return creator;
    }

    public void setCreator (String creator)
    {
        this.creator = creator;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [last_set = "+last_set+", creator = "+creator+", value = "+value+"]";
    }
}

}
	