/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.support;

import java.util.List;

import org.springframework.social.facebook.GraphApi;
import org.springframework.social.facebook.GroupApi;
import org.springframework.social.facebook.support.extractors.GroupResponseExtractor;
import org.springframework.social.facebook.support.extractors.ReferenceResponseExtractor;
import org.springframework.social.facebook.types.Group;
import org.springframework.social.facebook.types.Reference;

public class GroupApiImpl implements GroupApi {

	private GroupResponseExtractor groupExtractor;
	private final GraphApi graphApi;
	private ReferenceResponseExtractor referenceExtractor;

	public GroupApiImpl(GraphApi graphApi) {
		this.graphApi = graphApi;
		groupExtractor = new GroupResponseExtractor();
		referenceExtractor = new ReferenceResponseExtractor();
	}
	
	public Group getGroup(String groupId) {
		return graphApi.fetchObject(groupId, groupExtractor);
	}
	
	public List<Reference> getMembers(String groupId) {
		return graphApi.fetchConnections(groupId, "members", referenceExtractor);
	}
	
}
