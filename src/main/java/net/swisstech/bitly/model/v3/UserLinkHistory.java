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
package net.swisstech.bitly.model.v3;

import java.util.List;

import net.swisstech.bitly.model.DTO;

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

public class UserLinkHistory extends DTO {

	public long result_count;

	public List<UserLinkHistoryElement> link_history;

	public static class UserLinkHistoryElement extends DTO {

		public String aggregate_link;

		public boolean archived;

		public DateTime created_at;

		public String link;

		public String long_url;

		public DateTime modified_at;

		@SerializedName("private")
		public boolean privat;

		public String title;

		public DateTime user_ts;
	}
}