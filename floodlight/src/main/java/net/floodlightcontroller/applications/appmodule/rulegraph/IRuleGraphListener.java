package net.floodlightcontroller.applications.appmodule.rulegraph;

import java.util.Iterator;
import java.util.Set;

/**
 * Defines the events may be generated by {@link IRuleGraphService}.
 *
 * @implNote As we implement rule modification as a rule deletion followed with a rule insert operation,
 * we don't support rule modificatin event until now!
 * @author chunhui (chunhui.pang@outlook.com)
 */
public interface IRuleGraphListener {
    /**
     * A new rule node has been added to the rule graph
     * @param node the new rule node
     */
    void ruleAdded(IRuleNode node);

    /**
     * A existed rule node has been removed from current rule graph
     * @param node the removed rule graph
     */
    void ruleRemoved(IRuleNode node);

    /**
     * A existing rule node is modified
     * @param node the modified rule node
     */
    void ruleModified(IRuleNode node);

    /**
     * A new link is added
     * @param prev the previous rule
     * @param next the next hop rule
     */
    void linkAdded(IRuleNode prev, IRuleNode next);

    /**
     * A existing link is removed
     * @param prev the previous rule
     * @param next the next hop rule
     */
    void linkRemoved(IRuleNode prev, IRuleNode next);
}
