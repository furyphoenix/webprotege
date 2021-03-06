package edu.stanford.bmir.protege.web.shared.project;

import edu.stanford.bmir.protege.web.shared.dispatch.Action;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/04/2013
 */
public class MoveProjectsToTrashAction implements Action<MoveProjectsToTrashResult> {

    private Set<ProjectId> projectIds;

    private MoveProjectsToTrashAction() {
    }

    public MoveProjectsToTrashAction(Set<ProjectId> projectIds) {
        this.projectIds = new HashSet<ProjectId>(projectIds);
    }

    public Set<ProjectId> getProjectIds() {
        return new HashSet<ProjectId>(projectIds);
    }
}
