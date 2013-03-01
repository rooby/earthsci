/*******************************************************************************
 * Copyright 2013 Geoscience Australia
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package au.gov.ga.earthsci.intent;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description of an intent to be performed. Plugins can define an
 * {@link IntentFilter} that can handle matching intents.
 * <p/>
 * Modelled on Android's Intent system.
 * 
 * @author Michael de Hoog (michael.dehoog@ga.gov.au)
 */
public class Intent
{
	private String action;
	private final Set<String> categories = new HashSet<String>();
	private String type;
	private URI uri;
	private Class<? extends IntentHandler> handler;
	private final Map<String, Object> extras = new HashMap<String, Object>();
	private int flags;

	/**
	 * @return Action to be performed.
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * Set the action that this intent performs.
	 * 
	 * @param action
	 * @return this
	 */
	public Intent setAction(String action)
	{
		this.action = action;
		return this;
	}

	/**
	 * @return Categories associated with this intent.
	 */
	public Set<String> getCategories()
	{
		return categories;
	}

	/**
	 * Add a category to this intent.
	 * 
	 * @param category
	 * @return this
	 */
	public Intent addCategory(String category)
	{
		categories.add(category);
		return this;
	}

	/**
	 * Remove a category from this intent.
	 * 
	 * @param category
	 * @return this
	 */
	public Intent removeCategory(String category)
	{
		categories.remove(category);
		return this;
	}

	/**
	 * @return Explicit MIME type of the data associated with this intent.
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Set the explicit MIME type of the data associated with this intent.
	 * 
	 * @param type
	 * @return this
	 */
	public Intent setType(String type)
	{
		this.type = type;
		return this;
	}

	/**
	 * @return The URI of the data associated with this intent.
	 */
	public URI getURI()
	{
		return uri;
	}

	/**
	 * Set the URI of the data associated with this intent.
	 * 
	 * @param uri
	 * @return this
	 */
	public Intent setURI(URI uri)
	{
		this.uri = uri;
		return this;
	}

	/**
	 * @return The explicit handler class used to handle this intent.
	 */
	public Class<? extends IntentHandler> getHandler()
	{
		return handler;
	}

	/**
	 * Set the handler class used to handle this intent explicitly. If this is
	 * set, no other fields are required, as the {@link IntentFilter}s will not
	 * be searched to find an appropriate handler.
	 * 
	 * @param handler
	 * @return this
	 */
	public Intent setHandler(Class<? extends IntentHandler> handler)
	{
		this.handler = handler;
		return this;
	}

	/**
	 * @return Integer flags set on this intent.
	 */
	public int getFlags()
	{
		return flags;
	}

	/**
	 * Set the flags for this intent.
	 * 
	 * @param flags
	 * @return this
	 */
	public Intent setFlags(int flags)
	{
		this.flags = flags;
		return this;
	}

	/**
	 * Add a flag to this intent. Uses a bitwise OR.
	 * 
	 * @param flag
	 * @return this
	 */
	public Intent addFlag(int flag)
	{
		flags = flags | flag;
		return this;
	}

	/**
	 * Check if the given flag is set on this intent, using a bitwise AND.
	 * 
	 * @param flag
	 * @return True if the given flag is set on this intent.
	 */
	public boolean hasFlag(int flag)
	{
		return (flags & flag) == flag;
	}

	/**
	 * @return The extra data map associated with this intent.
	 */
	public Map<String, Object> getExtras()
	{
		return extras;
	}

	/**
	 * Lookup an extra by the given key on this intent.
	 * 
	 * @param key
	 * @return Extra object associated with the given key on this intent.
	 */
	public Object getExtra(String key)
	{
		return extras.get(key);
	}

	/**
	 * Set an extra keyed by the given key on this intent.
	 * 
	 * @param key
	 * @param value
	 * @return this
	 */
	public Intent putExtra(String key, Object value)
	{
		extras.put(key, value);
		return this;
	}
}
