/*
 * Copyright (c) Patrick Huber (gmail: stackmagic)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.swisstech.bitly.builder.v3;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.swisstech.bitly.builder.QueryParameter;
import net.swisstech.bitly.builder.Request;
import net.swisstech.bitly.model.ApiResponse;
import net.swisstech.bitly.model.v3.UserLinkEdit;

import org.joda.time.DateTime;

import com.google.gson.reflect.TypeToken;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_user_link_edit">/v3/user/link_edit</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkEditRequest extends Request<UserLinkEdit> {

	public UserLinkEditRequest(String accessToken) {
		super(accessToken);
	}

	@Override
	public String getEndpoint() {
		return "https://api-ssl.bitly.com/v3/user/link_edit";
	}

	@Override
	protected Type getTypeForGson() {
		return new TypeToken<ApiResponse<UserLinkEdit>>() {
		}.getType();
	}

	public UserLinkEditRequest setLink(String link) {
		addQueryParameter("link", link);
		return this;
	}

	public UserLinkEditRequest setTitle(String title) {
		addQueryParameter("title", title);
		return this;
	}

	public UserLinkEditRequest setNote(String note) {
		addQueryParameter("note", note);
		return this;
	}

	public UserLinkEditRequest setPrivate(boolean privat) {
		addQueryParameter("private", privat);
		return this;
	}

	public UserLinkEditRequest setUserTs(DateTime user_ts) {
		addQueryParameter("user_ts", user_ts);
		return this;
	}

	public UserLinkEditRequest setArchived(boolean archived) {
		addQueryParameter("archived", archived);
		return this;
	}

	@Override
	public String buildUrl() {
		List<QueryParameter> editParams = new LinkedList<QueryParameter>(getQueryParameters());
		Set<String> paramNames = new HashSet<String>();
		for (QueryParameter qp : editParams) {
			paramNames.add(qp.getName());
		}

		// can't have the link itself in the "edit" list
		paramNames.remove("link");

		StringBuffer paramNamesJoined = new StringBuffer();
		Iterator<String> paramNameIter = paramNames.iterator();
		while (paramNameIter.hasNext()) {
			String name = paramNameIter.next();
			paramNamesJoined.append(name);
			if (paramNameIter.hasNext()) {
				paramNamesJoined.append(",");
			}
		}

		List<QueryParameter> params = new LinkedList<QueryParameter>(getQueryParameters());
		params.add(new QueryParameter("edit", paramNamesJoined.toString()));
		return buildUrl(params);
	}
}