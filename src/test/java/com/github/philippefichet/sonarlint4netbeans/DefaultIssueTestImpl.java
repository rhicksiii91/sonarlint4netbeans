/*
 * sonarlint4netbeans: SonarLint integration for Apache Netbeans
 * Copyright (C) 2020 Philippe FICHET.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.github.philippefichet.sonarlint4netbeans;

import java.util.List;
import org.assertj.core.groups.Tuple;
import org.sonarsource.sonarlint.core.client.api.common.analysis.ClientInputFile;
import org.sonarsource.sonarlint.core.client.api.common.analysis.Issue;

/**
 *
 * @author FICHET Philippe &lt;philippe.fichet@laposte.net&gt;
 */
public class DefaultIssueTestImpl implements Issue {

    private final String severity;
    private final String type;
    private final String ruleKey;
    private final String ruleName;
    private final Integer startLine;
    private final Integer endLine;
    private final Integer startLineOffset;
    private final Integer endLineOffset;
    private final ClientInputFile clientInputFile;

    public DefaultIssueTestImpl(String severity, String type, String ruleKey, String ruleName, Integer startLine, Integer endLine, Integer startLineOffset, Integer endLineOffset, ClientInputFile clientInputFile) {
        this.severity = severity;
        this.type = type;
        this.ruleKey = ruleKey;
        this.ruleName = ruleName;
        this.startLine = startLine;
        this.endLine = endLine;
        this.startLineOffset = startLineOffset;
        this.endLineOffset = endLineOffset;
        this.clientInputFile = clientInputFile;
    }

    @Override
    public String getSeverity() {
        return severity;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getRuleKey() {
        return ruleKey;
    }

    @Override
    public String getRuleName() {
        return ruleName;
    }

    @Override
    public List<Flow> flows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientInputFile getInputFile() {
        return clientInputFile;
    }

    @Override
    public Integer getStartLine() {
        return startLine;
    }

    @Override
    public Integer getEndLine() {
        return endLine;
    }

    @Override
    public Integer getStartLineOffset() {
        return startLineOffset;
    }

    @Override
    public Integer getEndLineOffset() {
        return endLineOffset;
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Tuple toTuple()
    {
        return toTuple(this);
    }

    public static Tuple toTuple(Issue issue)
    {
        return Tuple.tuple(
            issue.getSeverity(),
            issue.getType(),
            issue.getRuleKey(),
            issue.getRuleName(),
            issue.getStartLine(),
            issue.getEndLine(),
            issue.getStartLineOffset(),
            issue.getEndLineOffset()
        );
    };
    
    public static class Builder
    {
        private String severity;
        private String type;
        private String ruleKey;
        private String ruleName;
        private Integer startLine;
        private Integer endLine;
        private Integer startLineOffset;
        private Integer endLineOffset;
        private ClientInputFile clientInputFile;

        public Builder severity(String severity)
        {
            this.severity = severity;
            return this;
        }

        public Builder type(String type)
        {
            this.type = type;
            return this;
        }
        
        public Builder ruleKey(String ruleKey)
        {
            this.ruleKey = ruleKey;
            return this;
        }
        
        public Builder ruleName(String ruleName)
        {
            this.ruleName = ruleName;
            return this;
        }

        public Builder startLine(Integer startLine)
        {
            this.startLine = startLine;
            return this;
        }
        
        public Builder endLine(Integer endLine)
        {
            this.endLine = endLine;
            return this;
        }
        
        public Builder startLineOffset(Integer startLineOffset)
        {
            this.startLineOffset = startLineOffset;
            return this;
        }
        
        public Builder endLineOffset(Integer endLineOffset)
        {
            this.endLineOffset = endLineOffset;
            return this;
        }
        
        public Builder clientInputFile(ClientInputFile clientInputFile)
        {
            this.clientInputFile = clientInputFile;
            return this;
        }

        public Issue build() {
            return new DefaultIssueTestImpl(
                severity,
                type,
                ruleKey,
                ruleName,
                startLine,
                endLine,
                startLineOffset,
                endLineOffset,
                clientInputFile
            );
        }
        public Tuple buildTuple() {
            return toTuple(new DefaultIssueTestImpl(
                severity,
                type,
                ruleKey,
                ruleName,
                startLine,
                endLine,
                startLineOffset,
                endLineOffset,
                null
            ));
        }
    }
}
